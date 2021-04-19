package com.team2.controller;

import com.team2.form.LoginForm;
import com.team2.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springmvc.xml","classpath:mybatisConfig.xml","classpath:spring.xml"})
public class LoginControllerTest {

    @Autowired
    LoginService loginService;

    @Autowired
    LoginController loginController;

    @Test
    public void login() {
        LoginForm loginFormC = new LoginForm("1", "123");
        LoginForm loginFormW = new LoginForm("1", "12");
        System.out.println(loginController.login(loginFormC));
        System.out.println(loginController.login(loginFormW));
    }

}