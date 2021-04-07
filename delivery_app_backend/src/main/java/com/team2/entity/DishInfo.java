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
    private String dishName;
    private BigDecimal dishPrice;
    private String dishTaste;
    private String dishImg;
}
