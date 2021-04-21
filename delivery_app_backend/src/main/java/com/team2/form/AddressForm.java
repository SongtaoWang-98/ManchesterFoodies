package com.team2.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressForm {
    private Integer userId;
    private String name;
    private String address;
    private String postcode;
    private String tel;
}
