package com.team2.service.impl;

import com.team2.dao.DishInfoDao;
import com.team2.dao.OrderInfoDao;
import com.team2.dao.UserCartDao;
import com.team2.dao.UserInfoDao;
import com.team2.entity.DishInfo;
import com.team2.entity.OrderInfo;
import com.team2.entity.UserCart;
import com.team2.enums.StatusCode;
import com.team2.service.OrderService;
import com.team2.vo.CurrentOrderVO;
import com.team2.vo.OrdersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    @Override
    public StatusCode createOrder(Integer userId, Integer addressId, String paymentMethod) {
        Integer cartId = userCartDao.findUnPaidCartIdByUserId(userId);
        List<UserCart> userCartList = userCartDao.findAllInCart(cartId);
        Integer restaurantId = dishInfoDao.findByDishId(userCartList.get(0).getDishId()).getRestaurantId();
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setUserId(userId);
        orderInfo.setCartId(cartId);
        orderInfo.setRestaurantId(restaurantId);
        orderInfo.setAddressId(addressId);
        orderInfo.setPaymentMethod(paymentMethod);
        orderInfo.setCreateTime(new Date());
        if(paymentMethod.equals("Balance")) {
            BigDecimal orderTotal = BigDecimal.valueOf(0);
            for(UserCart userCart: userCartList) {
                DishInfo dishInfo = dishInfoDao.findByDishId(userCart.getDishId());
                orderTotal = orderTotal.add(dishInfo.getDishPrice().multiply(BigDecimal.valueOf(userCart.getDishNum())));
            }
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
    public CurrentOrderVO viewCurrentOrder(Integer userId) {
        return null;
    }

    @Override
    public OrdersVO viewAllOrders(Integer userId) {
        return null;
    }
}
