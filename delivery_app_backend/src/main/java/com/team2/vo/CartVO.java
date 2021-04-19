package com.team2.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartVO {
    @JsonProperty("restaurant")
    private String restaurantName;
    @JsonProperty("time")
    private String estimateTime;
    @JsonProperty("items")
    private List<CartItemVO> cartItemVOList;
    @JsonProperty("discount")
    private Double discount;
    @JsonProperty("cut_price")
    private BigDecimal cutPrice;
    @JsonProperty("subtotal")
    private BigDecimal totalPrice;
    @JsonProperty("delivery_fee")
    private BigDecimal deliveryFee;
    @JsonProperty("order_total")
    private BigDecimal orderTotal;
}
