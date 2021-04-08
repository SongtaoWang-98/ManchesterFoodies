package com.team2.service.impl;

import com.team2.service.HomeService;
import com.team2.vo.HomeVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springmvc.xml","classpath:mybatisConfig.xml","classpath:spring.xml"})
public class HomeServiceImplTest {

    @Autowired
    private HomeService homeService;

    @Test
    public void findAllRestaurants() {
        HomeVO homeVO = homeService.findAllRestaurants();
        System.out.println(homeVO);
    }

}