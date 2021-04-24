package com.team2.service.impl;

import com.team2.dao.UserCartDao;
import com.team2.service.CartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springmvc.xml","classpath:mybatisConfig.xml","classpath:spring.xml"})
public class CartServiceImplTest {

    @Autowired
    private CartService cartService;

    @Test
    public void addItemTest() {
        cartService.addItem(1,1,5);
    }

    @Test
    public void deleteItemTest() {
        cartService.deleteItem(10);
    }

    @Test
    public void deleteAllInCartTest() {
        cartService.deleteAllInCart(1);
    }

    @Test
    public void updateItemTest() {
        cartService.updateItem(1,1);
    }

    @Test
    public void viewCartTest() {
        System.out.println(cartService.viewCart(2));
    }

}