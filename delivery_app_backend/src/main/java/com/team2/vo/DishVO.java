package com.team2.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * name: DishVO
 * description: To show detailed information of each dish.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishVO {
    @JsonProperty("id")
    private Integer dishId;
    @JsonProperty("name")
    private String dishName;
    @JsonProperty("description")
    private String dishDescription;
    @JsonProperty("price")
    private BigDecimal dishPrice;
    @JsonProperty("trend")
    private String dishTrend;
    @JsonProperty("img")
    private String dishImg;
}
