package com.team2.service.impl;

import com.team2.dao.DishInfoDao;
import com.team2.dao.RestaurantInfoDao;
import com.team2.dao.UserCartDao;
import com.team2.dao.UserInfoDao;
import com.team2.entity.DishInfo;
import com.team2.entity.RestaurantInfo;
import com.team2.entity.UserCart;
import com.team2.enums.StatusCode;
import com.team2.pattern.strategy.DeliveryFeeContext;
import com.team2.pattern.strategy.GeneralDeliveryFee;
import com.team2.pattern.strategy.VipDeliveryFee;
import com.team2.service.CartService;
import com.team2.util.DataUtil;
import com.team2.vo.CartItemVO;
import com.team2.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private UserCartDao userCartDao;

    @Autowired
    private RestaurantInfoDao restaurantInfoDao;

    @Autowired
    private DishInfoDao dishInfoDao;

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public StatusCode addItem(Integer userId, Integer dishId, Integer dishNum) {
        Integer cartMax = userCartDao.findMaxCartId();
        Integer cId = userCartDao.findUnPaidCartIdByUserId(userId);
        int cartId;
        if(cartMax == null) cartId = 1;
        else {
            if(cId == null) {
                cartId = cartMax + 1;
            }
            else {
                cartId = cId;
            }
        }
        if(userCartDao.findByCartIdAndDishId(cartId, dishId) != null) return StatusCode.ITEM_EXISTS;
        else {
            UserCart userCart = new UserCart();
            userCart.setCartId(cartId);
            userCart.setUserId(userId);
            userCart.setDishId(dishId);
            userCart.setDishNum(dishNum);
            userCartDao.save(userCart);
            return StatusCode.SUCCESS;
        }
    }

    @Override
    public StatusCode deleteItem(Integer id) {
        userCartDao.deleteById(id);
        return StatusCode.SUCCESS;
    }

    @Override
    public StatusCode deleteAllInCart(Integer userId) {
        Integer cartMax = userCartDao.findUnPaidCartIdByUserId(userId);
        userCartDao.deleteAllInCart(cartMax);
        return StatusCode.SUCCESS;
    }

    @Override
    public StatusCode updateItem(Integer id, Integer dishNum) {
        userCartDao.updateById(id, dishNum);
        return StatusCode.SUCCESS;
    }

    @Override

    public CartVO viewCart(Integer userId) {
        Integer cartMax = userCartDao.findUnPaidCartIdByUserId(userId);
        List<UserCart> userCartList = userCartDao.findAllInCart(cartMax);
        if (userCartList.isEmpty()) return null;
        List<CartItemVO> cartItemVOList = new ArrayList<>();
        for(UserCart userCart: userCartList) {
            DishInfo dishInfo = dishInfoDao.findByDishId(userCart.getDishId());
            cartItemVOList.add(new CartItemVO(
                    userCart.getId(),
                    dishInfo.getDishName(),
                    userCart.getDishNum(),
                    dishInfo.getDishPrice().multiply(BigDecimal.valueOf(userCart.getDishNum()))
            ));
        }

        Integer restaurantId = dishInfoDao.findByDishId(userCartList.get(0).getDishId()).getRestaurantId();
        RestaurantInfo restaurantInfo = restaurantInfoDao.findRestaurantById(restaurantId);
        BigDecimal total = BigDecimal.valueOf(0);
        for(CartItemVO cartItemVO: cartItemVOList) {
            total = total.add(cartItemVO.getDishPrice());
        }
        BigDecimal subtotal = total.multiply(BigDecimal.valueOf(restaurantInfo.getDiscount()))
                .setScale(2, RoundingMode.HALF_UP);
        BigDecimal cutPrice = total.subtract(subtotal)
                .setScale(2, RoundingMode.HALF_UP);
        DeliveryFeeContext context = new DeliveryFeeContext();
        Boolean isVip = userInfoDao.findByUserId(userId).getIsVip();
        if(isVip) context.setCalculateMethod(new VipDeliveryFee());
        else context.setCalculateMethod(new GeneralDeliveryFee());
        BigDecimal deliveryFee = context.CalculateFee(subtotal, restaurantInfo.getRestaurantDistance());
        BigDecimal orderTotal = subtotal.add(deliveryFee);
        return new CartVO(
                restaurantInfo.getRestaurantName(),
                DataUtil.evalDeliveryTime(restaurantInfo.getRestaurantDistance()),
                cartItemVOList,
                restaurantInfo.getDiscount(),
                cutPrice,
                subtotal,
                deliveryFee,
                orderTotal
        );
    }
}
