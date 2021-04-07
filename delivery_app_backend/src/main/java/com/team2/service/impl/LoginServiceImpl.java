package com.team2.service.impl;

import com.team2.dao.UserInfoDao;
import com.team2.entity.UserInfo;
import com.team2.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public boolean loginByName(String username, String password) {
        UserInfo userInfo = userInfoDao.findByName(username);
        if (userInfo == null) return false;
        else {
            return userInfo.getUserPassword().equals(password);
        }
    }

    @Override
    public boolean registerByName(String username, String password, String tel) {
        int userCount = userInfoDao.count();
        if(userInfoDao.findByName(username) != null) return false;
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userCount + 1);
        userInfo.setUserName(username);
        userInfo.setUserPassword(password);
        userInfo.setUserTel(tel);
        userInfoDao.save(userInfo);
        return true;
    }
}
