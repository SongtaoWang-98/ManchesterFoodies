package com.team2.service;

public interface LoginService {
    boolean loginByName(String username, String password);
    boolean registerByName(String username, String password, String tel);
}
