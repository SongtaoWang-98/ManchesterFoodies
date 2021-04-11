package com.team2.controller;

import com.team2.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * name: LoginController
 * description: It is the entrance of the app, and it provides user login and register.
 */
@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * url: localhost:8080/delivery_app/login
     * description: Login by username and password
     * param: String username, String password
     * return: boolean
     */
    @PostMapping()
    public boolean login(String username, String password) {
        return loginService.loginByName(username, password);
    }

}
