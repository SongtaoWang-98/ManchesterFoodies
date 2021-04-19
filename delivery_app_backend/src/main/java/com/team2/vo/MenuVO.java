package com.team2.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

/**
 * name: MenuVO
 * description: The view of the restaurant page, including all the dishes.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuVO {
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
    @JsonProperty("description")
    private String restaurantDescription;
    @JsonProperty("discount")
    private Double discount;
    @JsonProperty("estimate_time")
    private String estimateTime;
    @JsonProperty("groups")
    List<DishGroupVO> dishGroupVOList;
}
