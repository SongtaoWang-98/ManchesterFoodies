package com.team2.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterForm {
    private String userName;
    private String userPassword;
    private String userTel;
    private Boolean isVip;
}
