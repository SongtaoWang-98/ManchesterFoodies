package com.team2.enums;

import lombok.Getter;

@Getter
public enum UserCode {

    /* success code */
    SUCCESS(200, "SUCCESS"),

    /* fail code */
    USER_NOT_EXISTS(1001, "No such username"),
    PASSWORD_ERROR(1002, "Wrong password"),

    USERNAME_EXISTS(2001,"Username exists"),
    TEL_EXISTS(2002,"Tel number has been used"),

    FAIL(300,"Fail");


    private Integer code;
    private String message;

    UserCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
