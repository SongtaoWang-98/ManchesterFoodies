package com.team2.dao;

import com.team2.entity.OrderInfo;

import java.util.List;

public interface OrderInfoDao {
    void save(OrderInfo orderInfo);
    List<OrderInfo> findByUserIdOrderByTimeDesc(Integer userId);
}
