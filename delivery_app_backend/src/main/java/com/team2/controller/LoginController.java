package com.team2.controller;

import com.team2.form.LoginForm;
import com.team2.service.LoginService;
import com.team2.util.ResultVOUtil;
import com.team2.vo.ResultVO;
import com.team2.vo.UserVO;
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
     * url: localhost:8383/delivery_app/login
     * description: Login by username and password
     * param: String username, String password
     * return: boolean
     */
    @PostMapping
    public ResultVO login(@RequestBody LoginForm loginForm) {
        UserVO userVO = loginService.loginByName(loginForm.getUserName(), loginForm.getUserPassword());
        if(userVO.getCodeMsg().equals("SUCCESS")) {
            return ResultVOUtil.success(userVO);
        }
        else {
            return ResultVOUtil.fail(userVO);
        }
    }

}
