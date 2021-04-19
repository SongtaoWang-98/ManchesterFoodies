package com.team2.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springmvc.xml","classpath:mybatisConfig.xml","classpath:spring.xml"})
public class DishInfoDaoTest {

    @Autowired
    DishInfoDao dishInfoDao;

    @Test
    public void findGroups() {
        System.out.println(dishInfoDao.findByRestaurantIdAndDishGroup(1,"Starters"));
    }

}