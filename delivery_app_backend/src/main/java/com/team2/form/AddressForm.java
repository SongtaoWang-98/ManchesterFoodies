package com.team2.form;

import lombok.Data;

@Data
public class AddressForm {
    private Integer userId;
    private String address;
    private String postcode;
    private String tel;
}
