package com.team2.controller;

import com.team2.form.LoginForm;
import com.team2.form.RegisterForm;
import com.team2.service.LoginService;
import com.team2.util.ResultVOUtil;
import com.team2.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public ResultVO register(@RequestBody RegisterForm registerForm){
        System.out.println(registerForm.toString());
        return ResultVOUtil.success(loginService.registerByName(registerForm.getUserName(),
                registerForm.getUserPassword(), registerForm.getUserTel()));
    }
}
