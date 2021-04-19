package com.team2.entity;

import lombok.Data;

@Data
public class AddressInfo {
    private Integer addressId;
    private Integer userId;
    private String address;
    private String postcode;
    private String addressTel;
}
