package com.team2.controller;

import com.team2.service.HomeService;
import com.team2.vo.HelloVO;
import com.team2.vo.HomeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private HomeService homeService;

    @GetMapping
    public HelloVO helloWorld() {
        return new HelloVO("Hello World!");
    }

    @GetMapping("/find")
    public HomeVO index(){
        return new HomeVO(homeService.findAll());
    }


}
