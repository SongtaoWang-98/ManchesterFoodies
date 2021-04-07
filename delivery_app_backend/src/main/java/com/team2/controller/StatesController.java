package com.team2.controller;

import com.team2.service.StatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * name: StatesController
 * description: Show the details and current state of the order.
 */
@CrossOrigin
@RestController
@RequestMapping("/states")
public class StatesController {

    @Autowired
    private StatesService statesService;

}
