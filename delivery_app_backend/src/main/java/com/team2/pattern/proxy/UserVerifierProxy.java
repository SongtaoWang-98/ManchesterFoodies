package com.team2.pattern.proxy;

import com.team2.dao.UserInfoDao;
import com.team2.entity.UserInfo;
import com.team2.enums.UserCode;
import com.team2.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserVerifierProxy implements UserVerifier{

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private UserVerifierImpl userVerifier;

    @Override
    public UserVO verify(String username, String password) {
        UserInfo userInfo = userInfoDao.findByName(username);
        UserCode userCode = userVerifier.verify(username, password);
        if(userCode.getCode() != 200) {
            return new UserVO(null, null, userCode.getMessage());
        }
        else {
            return new UserVO(userInfo.getUserId(), username, userCode.getMessage());
        }
    }
}
