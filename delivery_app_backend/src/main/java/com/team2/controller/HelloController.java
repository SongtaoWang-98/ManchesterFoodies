package com.team2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * name: HelloController
 * description: It is the simple demo of the app, output hello world.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    /**
     * url: localhost:8080/delivery_app/hello
     * description: Hello world method in the initial demo
     * param:
     * return: String
     */
    @GetMapping
    public String hello() {
        System.out.println("2222");
        return "Hello World";
    }
}
