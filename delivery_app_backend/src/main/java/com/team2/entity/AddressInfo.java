package com.team2.entity;

import lombok.Data;

/**
 * name: AddressInfo
 * description: Information about users' addresses.
 */
@Data
public class AddressInfo {
    private Integer addressId;
    private Integer userId;
    private String name;
    private String address;
    private String postcode;
    private String addressTel;
}
