package com.team2.pattern.state;

public class PreparationState implements DeliveryState {
    @Override
    public String showCurrentState() {
        return "Preparing";
    }
}
