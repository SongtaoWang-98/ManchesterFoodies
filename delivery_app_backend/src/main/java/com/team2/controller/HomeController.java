package com.team2.controller;

import com.team2.service.HomeService;
import com.team2.vo.HomeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * name: HomeController
 * description: It is the first page after login.
 *              All the information of restaurants is shown here.
 */
@CrossOrigin
@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private HomeService homeService;

    /**
     * url: localhost:8080/delivery_app/home
     * description: Query and show all the information of restaurants from the database.
     * param:
     * return: HomeVO
     */
    @GetMapping()
    public HomeVO index(){
        return homeService.findAllRestaurants();
    }

}
