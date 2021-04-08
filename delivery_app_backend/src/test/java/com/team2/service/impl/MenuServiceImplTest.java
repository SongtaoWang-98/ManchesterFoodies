package com.team2.service.impl;

import com.team2.service.MenuService;
import com.team2.vo.MenuVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springmvc.xml","classpath:mybatisConfig.xml","classpath:spring.xml"})
public class MenuServiceImplTest {

    @Autowired
    MenuService menuService;

    @Test
    public void menuShow() {
        MenuVO menuVO = menuService.menuShow(1);
        System.out.println(menuVO);
    }
}