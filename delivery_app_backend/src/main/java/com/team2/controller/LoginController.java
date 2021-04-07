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
     * url: localhost:8080/delivery_app/login/hello
     * description: Hello world method in the initial demo
     * param:
     * return: String
    */
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

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

    /**
     * url: localhost:8080/delivery_app/login/register
     * description: Register by relative information
     * param: String username, String password, String tel
     * return: boolean
     */
    @PostMapping("/register")
    public boolean register(String username, String password, String tel){
        return loginService.registerByName(username, password, tel);
    }
}
