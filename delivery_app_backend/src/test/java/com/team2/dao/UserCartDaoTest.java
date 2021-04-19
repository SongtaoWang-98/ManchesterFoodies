package com.team2.dao;

import com.team2.entity.UserCart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springmvc.xml","classpath:mybatisConfig.xml","classpath:spring.xml"})
public class UserCartDaoTest {

    @Autowired
    UserCartDao userCartDao;

    @Test
    public void test() {
//        System.out.println(userCartDao.findMaxPaidCartId());
        System.out.println(userCartDao.findUnPaidCartIdByUserId(1));

    }

}