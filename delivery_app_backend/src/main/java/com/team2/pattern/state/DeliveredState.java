package com.team2.pattern.state;

public class DeliveredState implements DeliveryState{
    @Override
    public String showCurrentState() {
        return "Delivered";
    }
}
