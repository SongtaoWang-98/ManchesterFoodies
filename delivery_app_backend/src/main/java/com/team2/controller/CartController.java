package com.team2.controller;

import com.team2.enums.StatusCode;
import com.team2.service.CartService;
import com.team2.util.ResultVOUtil;
import com.team2.vo.CartVO;
import com.team2.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * name: CartController
 * description: Manage carts of users.
 */
@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public ResultVO addToCart(Integer userId, Integer dishId, Integer dishNum) {
        StatusCode statusCode = cartService.addItem(userId, dishId,dishNum);
        if(statusCode.getCode() == 200) {
            return ResultVOUtil.success(statusCode.getMsg());
        }
        else {
            return ResultVOUtil.fail(statusCode.getMsg());
        }
    }

    @PutMapping("/delete")
    public ResultVO deleteFromCart(Integer id) {
        return ResultVOUtil.success(cartService.deleteItem(id));
    }

    @PutMapping("/deleteAll")
    public ResultVO deleteAllInCart(Integer userId) {
        return ResultVOUtil.success(cartService.deleteAllInCart(userId));
    }

    @PutMapping("/update")
    public ResultVO updateInCart(Integer id, Integer dishNum) {
        return ResultVOUtil.success(cartService.updateItem(id,dishNum));
    }

    @GetMapping
    public ResultVO viewMyCart(Integer userId) {
        CartVO cartVO = cartService.viewCart(userId);
        if(cartVO == null) {
            return ResultVOUtil.fail(StatusCode.EMPTY_CART.getMsg());
        }
        else {
            return ResultVOUtil.success(cartVO);
        }
    }

}
