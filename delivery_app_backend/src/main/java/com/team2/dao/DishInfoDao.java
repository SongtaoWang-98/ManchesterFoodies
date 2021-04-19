package com.team2.dao;

import com.team2.entity.DishInfo;

import java.util.List;

public interface DishInfoDao {
    List<String> findDishGroups();
    List<DishInfo> findByRestaurantIdAndDishGroup(Integer restaurantId, String dishGroup);
    DishInfo findByDishId(Integer dishId);
}
