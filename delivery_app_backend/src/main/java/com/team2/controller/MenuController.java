package com.team2.controller;

import com.team2.service.MenuService;
import com.team2.vo.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * name: MenuController
 * description: It shows the menu of the chosen restaurant.
 */
@CrossOrigin
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
    public MenuVO menu(@PathVariable int id) {
        return menuService.menuShow(id);
    }
}
