package com.team2.enums;

import lombok.Getter;

@Getter
public enum LoginCode {

    /* success code */
    SUCCESS(200, "SUCCESS"),

    /* fail code */
    USER_NOT_EXISTS(1001, "No such username"),
    PASSWORD_ERROR(1002, "Wrong password"),

    FAIL(2001,"Fail");


    private Integer code;
    private String message;

    LoginCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
