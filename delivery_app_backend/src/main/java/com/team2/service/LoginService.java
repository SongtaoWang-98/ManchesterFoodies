package com.team2.service;

import com.team2.enums.LoginCode;
import com.team2.enums.RegisterCode;

public interface LoginService {
    LoginCode loginByName(String username, String password);
    RegisterCode registerByName(String username, String password, String tel);
}
