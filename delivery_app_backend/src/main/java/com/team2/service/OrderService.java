package com.team2.service;

import com.team2.enums.StatusCode;
import com.team2.vo.CurrentOrderVO;
import com.team2.vo.OrdersVO;

public interface OrderService {
    StatusCode createOrder(Integer userId, Integer addressId, String paymentMethod);
    CurrentOrderVO viewCurrentOrder(Integer userId);
    OrdersVO viewAllOrders(Integer userId);
}
