package com.team2.controller;

import com.team2.enums.LoginCode;
import com.team2.form.LoginForm;
import com.team2.service.LoginService;
import com.team2.util.ResultVOUtil;
import com.team2.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * name: LoginController
 * description: It is the entrance of the app, and it provides user login and register.
 */
@RestController
@CrossOrigin
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
    @PostMapping
    public ResultVO login(@RequestBody LoginForm loginForm) {
        System.out.println(loginForm.toString());
        LoginCode code = loginService.loginByName(loginForm.getUserName(), loginForm.getUserPassword());
        if(code.getCode()==200) return ResultVOUtil.success(loginForm.getUserName());
        else return ResultVOUtil.fail(code.getMessage());
    }

}
