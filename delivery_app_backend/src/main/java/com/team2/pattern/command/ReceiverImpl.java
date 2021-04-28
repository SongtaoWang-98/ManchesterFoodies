package com.team2.pattern.command;

import com.team2.dao.UserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Component
public class ReceiverImpl implements Receiver{

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public void deduce(Integer userId, BigDecimal amount) {
        BigDecimal balance = userInfoDao.findByUserId(userId).getUserBalance();
        BigDecimal currentBalance = balance.subtract(amount);
        userInfoDao.updateBalanceByUserId(userId, currentBalance);
    }

    @Override
    public void recharge(Integer userId, BigDecimal amount) {
        BigDecimal balance = userInfoDao.findByUserId(userId).getUserBalance();
        BigDecimal currentBalance = balance.add(amount);
        userInfoDao.updateBalanceByUserId(userId, currentBalance);
    }
}
