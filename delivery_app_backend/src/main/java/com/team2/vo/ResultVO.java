package com.team2.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private T data;
}
