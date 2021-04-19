package com.team2.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItemVO {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String dishName;
    @JsonProperty("num")
    private Integer dishNum;
    @JsonProperty("price")
    private BigDecimal dishPrice;
}
