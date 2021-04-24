package com.team2.service.impl;

import com.team2.dao.UserInfoDao;
import com.team2.entity.UserInfo;
import com.team2.enums.UserCode;
import com.team2.pattern.factory.PersonProfile;
import com.team2.pattern.factory.RegisterFactory;
import com.team2.pattern.proxy.UserVerifierProxy;
import com.team2.service.LoginService;
import com.team2.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private UserVerifierProxy userVerifierProxy;

    @Override
    public UserVO loginByName(String username, String password) {
        return userVerifierProxy.verify(username, password);
    }

    @Override
    public UserVO registerByName(String username, String password, String tel, String userType) {
        Integer userId = userInfoDao.findMaxId();
        if(userId == null) userId = 1;
        else userId++;
        UserCode userCode;
        if(userInfoDao.findByName(username) != null) {
            userCode =  UserCode.USERNAME_EXISTS;
            return new UserVO(null, null, userCode.getMessage());
        }
        PersonProfile personProfile = RegisterFactory.getPersonProfile(username, password, tel, userType);
        personProfile.showPersonProfile();
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setUserName(personProfile.getUserName());
        userInfo.setUserPassword(personProfile.getUserPassword());
        userInfo.setUserTel(personProfile.getUserTel());
        userInfo.setIsVip(personProfile.getIsVip());
        userInfoDao.save(userInfo);
        userCode =  UserCode.SUCCESS;
        return new UserVO(userInfo.getUserId(), userInfo.getUserName(), userCode.getMessage());
    }
}
