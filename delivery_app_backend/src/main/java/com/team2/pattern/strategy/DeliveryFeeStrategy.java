package com.team2.pattern.strategy;

import java.math.BigDecimal;

public interface DeliveryFeeStrategy {
    BigDecimal CalculateDeliveryFee(BigDecimal subTotal, Double distance);
}
