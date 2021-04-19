package com.team2.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * name: DishInfo
 * description: Information about each dish in a restaurant.
 */
@Data
public class DishInfo {
    private Integer dishId;
    private Integer restaurantId;
    private String dishGroup;
    private String dishName;
    private String dishDescription;
    private BigDecimal dishPrice;
    private String dishTrend;
    private String dishImg;
}
