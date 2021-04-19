package com.team2.service.impl;

import com.team2.dao.UserInfoDao;
import com.team2.entity.UserInfo;
import com.team2.enums.UserCode;
import com.team2.service.LoginService;
import com.team2.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserVO loginByName(String username, String password) {
        UserInfo userInfo = userInfoDao.findByName(username);
        UserCode userCode;
        if (userInfo == null) {
            userCode =  UserCode.USER_NOT_EXISTS;
        }
        else {
            if(userInfo.getUserPassword().equals(password)){
            userCode = UserCode.SUCCESS;
            return new UserVO(userInfo.getUserId(), userInfo.getUserName(), userCode.getMessage());
            }
            else userCode =  UserCode.PASSWORD_ERROR;
        }
        return new UserVO(null, null, userCode.getMessage());
    }

    @Override
    public UserVO registerByName(String username, String password, String tel) {
        int userCount = userInfoDao.count();
        UserCode userCode;
        if(userInfoDao.findByName(username) != null) {
            userCode =  UserCode.USERNAME_EXISTS;
            return new UserVO(null, null, userCode.getMessage());
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userCount + 1);
        userInfo.setUserName(username);
        userInfo.setUserPassword(password);
        userInfo.setUserTel(tel);
        userInfoDao.save(userInfo);
        userCode =  UserCode.SUCCESS;
        return new UserVO(userInfo.getUserId(), userInfo.getUserName(), userCode.getMessage());
    }
}
