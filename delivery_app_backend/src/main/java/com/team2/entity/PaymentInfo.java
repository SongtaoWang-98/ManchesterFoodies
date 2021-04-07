package com.team2.entity;

import lombok.Data;

/**
 * name: PaymentInfo
 * description: Information about addresses and some other items.
 */
@Data
public class PaymentInfo {
    private Integer paymentId;
    private Integer userId;
    private String paymentAddress;
}
