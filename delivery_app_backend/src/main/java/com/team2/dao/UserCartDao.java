package com.team2.dao;

import com.team2.entity.UserCart;

import java.util.List;

public interface UserCartDao {
    Integer findMaxCartId();
    UserCart findByCartIdAndDishId(Integer cartId, Integer dishId);
    void save(UserCart userCart);
    void deleteById(Integer id);
    void deleteAllInCart(Integer cartId);
    Integer findUnPaidCartIdByUserId(Integer userId);
    void updateById(Integer id, Integer dishNum);
    List<UserCart> findAllInCart(Integer cartId);
    void updatePaid(Integer cartId);
}
