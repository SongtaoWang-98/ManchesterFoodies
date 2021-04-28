package com.team2.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    @JsonProperty("id")
    private Integer userId;
    @JsonProperty("name")
    private String userName;
    @JsonProperty("code_msg")
    private String codeMsg;
}
