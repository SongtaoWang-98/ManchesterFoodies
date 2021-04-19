package com.team2.service.impl;

import com.team2.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springmvc.xml","classpath:mybatisConfig.xml","classpath:spring.xml"})
public class OrderServiceImplTest {

    @Autowired
    OrderService orderService;

    @Test
    public void createOrder() {
        System.out.println(orderService.createOrder(1,4,"Card"));
    }

}