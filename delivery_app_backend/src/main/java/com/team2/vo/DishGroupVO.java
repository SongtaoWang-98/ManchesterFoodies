package com.team2.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishGroupVO {
    @JsonProperty("group")
    private String dishGroup;
    @JsonProperty("dishes")
    List<DishVO> dishVOList;
}