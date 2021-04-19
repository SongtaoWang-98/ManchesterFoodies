package com.team2.dao;

import com.team2.entity.UserInfo;

import java.math.BigDecimal;
import java.util.List;

public interface UserInfoDao {
    UserInfo findByName(String name);
    void save(UserInfo userInfo);
    Integer count();
    UserInfo findByUserId(Integer userId);
    void updateBalanceByUserId(Integer userId, BigDecimal balance);
}
