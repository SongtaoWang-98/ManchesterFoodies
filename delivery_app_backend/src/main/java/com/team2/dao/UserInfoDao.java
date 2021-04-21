package com.team2.dao;

import com.team2.entity.UserInfo;

import java.math.BigDecimal;
import java.util.List;

public interface UserInfoDao {
    Integer findMaxId();
    UserInfo findByName(String name);
    void save(UserInfo userInfo);
    UserInfo findByUserId(Integer userId);
    void updateBalanceByUserId(Integer userId, BigDecimal balance);
}
