package com.team2.entity;

import lombok.Data;

@Data
public class UserCart {
    private Integer id;
    private Integer cartId;
    private Integer userId;
    private Integer dishId;
    private Integer dishNum;
    private Boolean isPaid;
}
