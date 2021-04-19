package com.team2.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * name: RestaurantVO
 * description: To show detailed information of each restaurant.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantVO {
    @JsonProperty("id")
    private Integer restaurantId;
    @JsonProperty("name")
    private String restaurantName;
    @JsonProperty("distance")
    private Double restaurantDistance;
    @JsonProperty("delivery_fee")
    private BigDecimal deliveryFee;
    @JsonProperty("stars")
    private Double restaurantStars;
    @JsonProperty("comment")
    private String restaurantComment;
    @JsonProperty("style")
    private String restaurantStyle;
    @JsonProperty("img")
    private String restaurantImg;
    @JsonProperty("discount")
    private Double discount;
}
