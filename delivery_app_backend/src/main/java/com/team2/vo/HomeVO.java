package com.team2.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.team2.entity.RestaurantInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * name: HomeVO
 * description: The view of the home page, including all the restaurants.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeVO {
    @JsonProperty("restaurants")
    List<RestaurantVO> restaurantVOList;
}
