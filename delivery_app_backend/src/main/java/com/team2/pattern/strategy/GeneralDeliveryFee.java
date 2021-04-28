package com.team2.pattern.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class GeneralDeliveryFee implements DeliveryFeeStrategy{
    @Override
    public BigDecimal CalculateDeliveryFee(BigDecimal subTotal, Double distance) {
        BigDecimal deliveryFee;
        if(subTotal.doubleValue() >= 30) deliveryFee = BigDecimal.valueOf(0);
        else {
            if(distance <= 1) deliveryFee = BigDecimal.valueOf(distance).multiply(BigDecimal.valueOf(1));
            else if(distance <= 2) deliveryFee = BigDecimal.valueOf(distance - 1)
                        .multiply(BigDecimal.valueOf(2.5)).add(BigDecimal.valueOf(1));
            else deliveryFee = BigDecimal.valueOf(distance - 2)
                        .multiply(BigDecimal.valueOf(5)).add(BigDecimal.valueOf(3.5));
        }
        return deliveryFee.setScale(2, RoundingMode.HALF_UP);
    }
}
