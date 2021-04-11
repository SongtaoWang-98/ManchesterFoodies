package com.team2.enums;

import lombok.Getter;

@Getter
public enum RegisterCode {
    SUCCESS(200,"SUCCESS"),

    USERNAME_EXISTS(1001,"Username exists"),
    TEL_EXISTS(1002,"Tel number has been used"),

    FAIL(2001,"Fail");

    private Integer code;
    private String msg;

    RegisterCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
