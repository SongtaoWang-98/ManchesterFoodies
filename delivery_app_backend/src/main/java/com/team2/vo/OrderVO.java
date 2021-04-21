package com.team2.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderVO {
    @JsonProperty("state")
    private String status;
    @JsonProperty("restaurant")
    private String restaurantName;
    @JsonProperty("img")
    private String restaurantImg;
    @JsonProperty("time")
    private String createTime;
    @JsonProperty("total")
    private BigDecimal orderTotal;
}
