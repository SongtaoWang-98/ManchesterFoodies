package com.team2.dao;

import com.team2.entity.UserInfo;

import java.util.List;

public interface UserInfoDao {
    public UserInfo findByName(String name);
    public int save(UserInfo userInfo);
    public int count();
}
