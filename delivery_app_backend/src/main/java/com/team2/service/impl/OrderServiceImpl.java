package com.team2.service.impl;

import com.team2.dao.*;
import com.team2.entity.OrderInfo;
import com.team2.entity.RestaurantInfo;
import com.team2.entity.UserCart;
import com.team2.enums.StatusCode;
import com.team2.pattern.state.*;
import com.team2.pattern.strategy.DeliveryFeeContext;
import com.team2.pattern.strategy.GeneralDeliveryFee;
import com.team2.pattern.strategy.VipDeliveryFee;
import com.team2.service.OrderService;
import com.team2.util.DataUtil;
import com.team2.vo.OrderVO;
import com.team2.vo.OrdersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderInfoDao orderInfoDao;

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private UserCartDao userCartDao;

    @Autowired
    private DishInfoDao dishInfoDao;

    @Autowired
    private RestaurantInfoDao restaurantInfoDao;

    @Override
    public BigDecimal checkBalance(Integer userId) {
        return userInfoDao.findByUserId(userId).getUserBalance();
    }

    @Override
    public StatusCode createOrder(Integer userId, Integer addressId, String paymentMethod) {
        Integer cartId = userCartDao.findUnPaidCartIdByUserId(userId);
        List<UserCart> userCartList = userCartDao.findAllInCart(cartId);
        BigDecimal orderTotal = BigDecimal.valueOf(0);
        for(UserCart userCart: userCartList) {
            orderTotal = orderTotal.add(dishInfoDao.findByDishId(userCart.getDishId()).getDishPrice()
                    .multiply(BigDecimal.valueOf(userCart.getDishNum())));
        }
        Integer restaurantId = dishInfoDao.findByDishId(userCartList.get(0).getDishId()).getRestaurantId();
        RestaurantInfo restaurantInfo = restaurantInfoDao.findRestaurantById(restaurantId);
        orderTotal = orderTotal.multiply(BigDecimal.valueOf(restaurantInfo.getDiscount()));
        DeliveryFeeContext context = new DeliveryFeeContext();
        Boolean isVip = userInfoDao.findByUserId(userId).getIsVip();
        if(isVip) context.setCalculateMethod(new VipDeliveryFee());
        else context.setCalculateMethod(new GeneralDeliveryFee());
        BigDecimal deliveryFee = context.CalculateFee(orderTotal, restaurantInfo.getRestaurantDistance());
        orderTotal = orderTotal.add(deliveryFee);
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setUserId(userId);
        orderInfo.setCartId(cartId);
        orderInfo.setRestaurantId(restaurantId);
        orderInfo.setAddressId(addressId);
        orderInfo.setPaymentMethod(paymentMethod);
        orderInfo.setCreateTime(new Date());
        orderInfo.setOrderTotal(orderTotal);
        if(paymentMethod.equals("balance")) {
            if (orderTotal.doubleValue() > userInfoDao.findByUserId(userId).getUserBalance().doubleValue()) {
                return StatusCode.INSUFFICIENT_BALANCE;
            }
            else {
                BigDecimal currentBalance = userInfoDao.findByUserId(userId).getUserBalance().subtract(orderTotal);
                userInfoDao.updateBalanceByUserId(userId, currentBalance);
            }
        }
        orderInfoDao.save(orderInfo);
        userCartDao.updatePaid(cartId);
        return StatusCode.SUCCESS;
    }

    @Override
    public OrdersVO viewAllOrders(Integer userId) {
        List<OrderInfo> orderInfoList = orderInfoDao.findByUserId(userId);
        List<OrderVO> orderVOList = new ArrayList<>();
        StateContext stateContext = new StateContext();
        Date now = new Date();
        for(OrderInfo orderInfo: orderInfoList) {
            RestaurantInfo restaurantInfo = restaurantInfoDao.findRestaurantById(orderInfo.getRestaurantId());
            Date orderTime = orderInfo.getCreateTime();
            if(now.before(new Date(orderTime.getTime() + 5 * 1000))) stateContext.setState(new PreparationState());
            else if(now.before(new Date(orderTime.getTime() + 10 * 1000))) stateContext.setState(new PickupState());
            else if(now.before(new Date(orderTime.getTime() + 15 * 1000))) stateContext.setState(new OnTheWayState());
            else stateContext.setState(new DeliveredState());
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            orderVOList.add(new OrderVO(
                    stateContext.showState(),
                    restaurantInfo.getRestaurantName(),
                    restaurantInfo.getRestaurantImg(),
                    dateFormat.format(orderInfo.getCreateTime()),
                    orderInfo.getOrderTotal()
            ));
        }
        return new OrdersVO(orderVOList);
    }
}
