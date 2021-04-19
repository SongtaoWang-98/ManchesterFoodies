package com.team2.controller;

import com.team2.form.RegisterForm;
import com.team2.service.LoginService;
import com.team2.util.ResultVOUtil;
import com.team2.vo.ResultVO;
import com.team2.vo.UserVO;
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
     * url: localhost:8383/delivery_app/register
     * description: Register by relative information
     * param: String username, String password, String tel
     * return: boolean
     */
    @PostMapping
    public ResultVO register(@RequestBody RegisterForm registerForm){
        UserVO userVO = loginService.registerByName(registerForm.getUserName(), registerForm.getUserPassword(),
                registerForm.getUserTel());
        if(userVO.getCodeMsg().equals("SUCCESS")) {
            return ResultVOUtil.success(userVO);
        }
        else {
            return ResultVOUtil.fail(userVO);
        }
    }

}
