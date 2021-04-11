package com.team2.service.impl;

import com.team2.entity.UserInfo;
import com.team2.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springmvc.xml","classpath:mybatisConfig.xml","classpath:spring.xml"})
public class LoginServiceImplTest {

    @Autowired
    LoginService loginService;

    @Test
    public void loginByName() {
//        assertTrue(loginService.loginByName("Stewart", "123"));
//        assertFalse(loginService.loginByName("Stewart","111"));
    }

//    @Test
//    public void registerByName() {
//        assertTrue(loginService.registerByName("1","123","12345677"));
//    }
}