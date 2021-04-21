package com.team2.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressVO {
    @JsonProperty("id")
    private Integer addressId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("address")
    private String address;
    @JsonProperty("postcode")
    private String postcode;
    @JsonProperty("tel")
    private String addressTel;
}
