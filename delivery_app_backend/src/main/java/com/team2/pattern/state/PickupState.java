package com.team2.pattern.state;

public class PickupState implements DeliveryState{
    @Override
    public String showCurrentState() {
        return "Picking up";
    }
}
