package com.team2.controller;

import com.team2.enums.StatusCode;
import com.team2.service.OrderService;
import com.team2.util.ResultVOUtil;
import com.team2.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * name: OrderController
 * description: Manage orders of users.
 */
@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/balance")
    public ResultVO checkBalance(Integer userId) {
        return ResultVOUtil.success(orderService.checkBalance(userId));
    }

    @PostMapping("/create")
    public ResultVO createOrder(Integer userId, Integer addressId, String paymentMethod) {
        StatusCode statusCode = orderService.createOrder(userId, addressId, paymentMethod);
        if(statusCode.getCode() == 200) {
            return ResultVOUtil.success(statusCode.getMsg());
        }
        else {
            return ResultVOUtil.fail(statusCode.getMsg());
        }
    }

    @GetMapping("/all")
    public ResultVO viewAllOrders(Integer userId) {
        return ResultVOUtil.success(orderService.viewAllOrders(userId));
    }

}
