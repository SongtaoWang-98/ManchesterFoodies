package com.team2.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * name: OrderInfo
 * description: Information about an order.
 */
@Data
public class OrderInfo {
    private Integer orderId;
    private Integer userId;
    private String address;
    private Integer restaurantId;
    private Integer dishId;
    private String deliveryMethod;
    private BigDecimal price;
}
