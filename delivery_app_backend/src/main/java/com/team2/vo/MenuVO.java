package com.team2.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * name: MenuVO
 * description: The view of the restaurant page, including all the dishes.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuVO {
    @JsonProperty("dishes")
    List<DishVO> dishVOList;
}
