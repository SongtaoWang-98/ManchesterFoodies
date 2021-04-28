package com.team2.controller;

import com.team2.enums.StatusCode;
import com.team2.service.UserService;
import com.team2.util.ResultVOUtil;
import com.team2.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * name: UserController
 * description: Manage information of users.
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/recharge")
    public ResultVO recharge(Integer userId, BigDecimal amount) {
        return ResultVOUtil.success(userService.recharge(userId, amount));
    }

    @GetMapping("/name")
    public ResultVO getUserName(Integer userId) {
        return ResultVOUtil.success(userService.getName(userId));
    }

    @GetMapping("/isVip")
    public ResultVO isVip(Integer userId) {
        return ResultVOUtil.success(userService.isVip(userId));
    }

    @PutMapping("/membership")
    public ResultVO openVip(Integer userId, String paymentMethod) {
        StatusCode statusCode = userService.openVip(userId, paymentMethod);
        if(statusCode.getCode() == 200) {
            return ResultVOUtil.success(statusCode.getMsg());
        }
        else {
            return ResultVOUtil.fail(statusCode.getMsg());
        }
    }
}
