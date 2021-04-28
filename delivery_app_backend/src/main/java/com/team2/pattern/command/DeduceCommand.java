package com.team2.pattern.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DeduceCommand implements Command{
    @Autowired
    private Receiver receiver;

    @Override
    public void execute(Integer userId, BigDecimal amount) {
        receiver.deduce(userId, amount);
    }
}
