package com.team2.pattern.command;

import java.math.BigDecimal;

public interface Receiver {
    void recharge(Integer userId, BigDecimal amount);
    void deduce(Integer userId, BigDecimal amount);
}
