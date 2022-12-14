package com.team2.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * name: UserInfo
 * description: Information about a user.
 */
@Data
public class UserInfo {
    private Integer userId;
    private String userName;
    private String userPassword;
    private String userTel;
    private BigDecimal userBalance;
    private Boolean isVip;
}
