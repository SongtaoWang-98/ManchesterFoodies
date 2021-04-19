package com.team2.dao;

import com.team2.entity.RestaurantInfo;

import java.util.List;

public interface RestaurantInfoDao {
    List<RestaurantInfo> findAllRestaurants();
    RestaurantInfo findRestaurantById(Integer restaurantId);
}
