package com.team2.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrentOrderVO {
    private String currentStatus;
    private String deliveryTime;
    private String restaurantName;
    private BigDecimal orderTotal;
}
