package com.team2.pattern.state;

import com.team2.dao.RestaurantInfoDao;
import com.team2.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;

public class StateContext {
    private DeliveryState state = null;

    public void setState(DeliveryState state) {
        this.state = state;
    }

    public String showState() {
        return state.showCurrentState();
    }
}
