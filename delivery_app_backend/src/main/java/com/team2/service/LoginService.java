package com.team2.service;

import com.team2.enums.UserCode;
import com.team2.vo.UserVO;

public interface LoginService {
    UserVO loginByName(String username, String password);
    UserVO registerByName(String username, String password, String tel);
}
