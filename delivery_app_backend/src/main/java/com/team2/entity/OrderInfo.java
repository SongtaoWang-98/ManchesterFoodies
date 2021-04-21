package com.team2.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * name: OrderInfo
 * description: Information about an order.
 */
@Data
public class OrderInfo {
    private Integer orderId;
    private Integer userId;
    private Integer cartId;
    private Integer restaurantId;
    private Integer addressId;
    private String paymentMethod;
    private Date createTime;
    private BigDecimal orderTotal;
}
