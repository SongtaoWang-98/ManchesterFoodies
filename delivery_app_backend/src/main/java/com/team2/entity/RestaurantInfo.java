package com.team2.entity;

import lombok.Data;

/**
 * name: RestaurantInfo
 * description: Information about a restaurant.
 */
@Data
public class RestaurantInfo {
    private Integer restaurantId;
    private String restaurantName;
    private Double restaurantDistance;
    private Double restaurantStars;
    private String restaurantStyle;
    private String restaurantImg;
    private String restaurantDescription;
    private Double discount;
}
