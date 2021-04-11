package com.team2.controller;

import com.team2.service.MenuService;
import com.team2.util.ResultVOUtil;
import com.team2.vo.MenuVO;
import com.team2.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * name: MenuController
 * description: It shows the menu of the chosen restaurant.
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * url: localhost:8080/delivery_app/menu/{id}
     * description: Show the dishes of the exact restaurant.
     * param: int id
     * return: MenuVO
     */
    @GetMapping("/{id}")
    public ResultVO menu(@PathVariable int id) {
        return ResultVOUtil.success(menuService.menuShow(id));
    }
}
