package com.team2.enums;

import lombok.Getter;

@Getter
public enum StatusCode {
    SUCCESS(200,"SUCCESS"),

    INSUFFICIENT_STOCK(1001,"Stock insufficient"),
    ITEM_EXISTS(1002,"It exists in cart"),

    INSUFFICIENT_BALANCE(2001,"Insufficient balance"),

    EMPTY_CART(3001, "Empty"),

    FAIL(2001,"Fail");


    private Integer code;
    private String msg;

    StatusCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
