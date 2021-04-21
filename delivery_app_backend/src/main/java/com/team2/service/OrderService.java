package com.team2.service;

import com.team2.enums.StatusCode;
import com.team2.vo.OrdersVO;

import java.math.BigDecimal;

public interface OrderService {
    BigDecimal checkBalance(Integer userId);
    StatusCode createOrder(Integer userId, Integer addressId, String paymentMethod);
    OrdersVO viewAllOrders(Integer userId);
}
