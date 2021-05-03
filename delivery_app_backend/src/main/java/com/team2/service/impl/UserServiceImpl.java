package com.team2.service.impl;

import com.team2.dao.UserInfoDao;
import com.team2.enums.StatusCode;
import com.team2.pattern.command.DeduceCommand;
import com.team2.pattern.command.Invoker;
import com.team2.pattern.command.RechargeCommand;
import com.team2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private RechargeCommand rechargeCommand;

    @Autowired
    private DeduceCommand deduceCommand;

    @Override
    public String getName(Integer userId) {
        return userInfoDao.findByUserId(userId).getUserName();
    }

    @Override
    public Boolean isVip(Integer userId) {
        return userInfoDao.findByUserId(userId).getIsVip();
    }

    @Override
    public StatusCode openVip(Integer userId, String paymentMethod) {
        if(paymentMethod.equals("balance")) {
            if (userInfoDao.findByUserId(userId).getUserBalance().doubleValue() < 5.99) {
                return StatusCode.INSUFFICIENT_BALANCE;
            }
            else {
                new Invoker(deduceCommand).execution(userId, BigDecimal.valueOf(5.99));
            }
        }
        userInfoDao.updateIsVipByUserId(userId);
        return StatusCode.SUCCESS;
    }

    @Override
    public StatusCode recharge(Integer userId, BigDecimal amount) {
        new Invoker(rechargeCommand).execution(userId, amount);
        return StatusCode.SUCCESS;
    }
}
