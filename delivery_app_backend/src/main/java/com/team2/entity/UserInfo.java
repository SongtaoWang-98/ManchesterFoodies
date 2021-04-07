package com.team2.entity;

import lombok.Data;

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
}
