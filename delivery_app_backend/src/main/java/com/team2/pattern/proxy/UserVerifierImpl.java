package com.team2.pattern.proxy;

import com.team2.dao.UserInfoDao;
import com.team2.entity.UserInfo;
import com.team2.enums.UserCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserVerifierImpl implements UserVerifier{

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserCode verify(String username, String password) {
        UserInfo userInfo = userInfoDao.findByName(username);
        UserCode userCode;
        if (userInfo == null) {
            userCode =  UserCode.USER_NOT_EXISTS;
        }
        else {
            if(userInfo.getUserPassword().equals(password)){
                userCode = UserCode.SUCCESS;
            }
            else userCode =  UserCode.PASSWORD_ERROR;
        }
        return userCode;
    }
}
