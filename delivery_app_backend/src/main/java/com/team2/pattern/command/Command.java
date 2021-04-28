package com.team2.pattern.command;

import java.math.BigDecimal;

public interface Command {
    void execute(Integer userId, BigDecimal amount);
}
