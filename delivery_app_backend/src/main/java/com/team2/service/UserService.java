package com.team2.service;

import com.team2.enums.StatusCode;

import java.math.BigDecimal;

public interface UserService {
    String getName(Integer userId);
    Boolean isVip(Integer userId);
    StatusCode openVip(Integer userId, String paymentMethod);
    StatusCode recharge(Integer userId, BigDecimal amount);
}
