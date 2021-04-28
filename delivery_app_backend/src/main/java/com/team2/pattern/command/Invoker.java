package com.team2.pattern.command;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

public class Invoker {
    public Command command;
    public Invoker(Command c) {
        this.command =  c;
    }
    public void execution(Integer userId, BigDecimal amount) {
        this.command.execute(userId, amount);
    }
}
