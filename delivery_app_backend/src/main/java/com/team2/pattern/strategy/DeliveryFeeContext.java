package com.team2.pattern.strategy;

import java.math.BigDecimal;

public class DeliveryFeeContext {
    private DeliveryFeeStrategy strategy;

    public DeliveryFeeStrategy getStrategy() {
        return strategy;
    }

    public void setCalculateMethod(DeliveryFeeStrategy strategy) {
        this.strategy = strategy;
    }

    public BigDecimal CalculateFee(BigDecimal subTotal, Double distance) {
        return strategy.CalculateDeliveryFee(subTotal, distance);
    }
}
