package com.team2.dao;

import com.team2.entity.DishInfo;

import java.util.List;

public interface DishInfoDao {
    List<DishInfo> findByRestaurant(int restaurantId);
}
