package com.team2.pattern.state;

public class OnTheWayState implements DeliveryState{
    @Override
    public String showCurrentState() {
        return "On the way";
    }
}
