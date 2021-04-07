package com.team2.dao;

import com.team2.entity.RestaurantInfo;

import java.util.List;

public interface RestaurantInfoDao {
    public List<RestaurantInfo> findAllRestaurants();
}
