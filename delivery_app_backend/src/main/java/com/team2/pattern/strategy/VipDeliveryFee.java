package com.team2.pattern.strategy;

import java.math.BigDecimal;

public class VipDeliveryFee implements DeliveryFeeStrategy{
    @Override
    public BigDecimal CalculateDeliveryFee(BigDecimal subTotal, Double distance) {
        BigDecimal deliveryFee;
        if(subTotal.doubleValue() >= 10) deliveryFee = BigDecimal.valueOf(0);
        else {
            if(distance <= 1) deliveryFee = BigDecimal.valueOf(distance).multiply(BigDecimal.valueOf(0.5));
            else if(distance <= 2) deliveryFee = BigDecimal.valueOf(distance - 1)
                    .multiply(BigDecimal.valueOf(2)).add(BigDecimal.valueOf(0.5));
            else deliveryFee = BigDecimal.valueOf(distance - 2)
                        .multiply(BigDecimal.valueOf(4)).add(BigDecimal.valueOf(2.5));
        }
        return deliveryFee;
    }
}
