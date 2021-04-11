package com.team2.controller;

import com.team2.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * name: RegisterController
 * description: It provides user register.
 */
@CrossOrigin
@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private LoginService loginService;
    /**
     * url: localhost:8080/delivery_app/register
     * description: Register by relative information
     * param: String username, String password, String tel
     * return: boolean
     */
    @PostMapping()
    public boolean register(String username, String password, String tel){
        return loginService.registerByName(username, password, tel);
    }
}
