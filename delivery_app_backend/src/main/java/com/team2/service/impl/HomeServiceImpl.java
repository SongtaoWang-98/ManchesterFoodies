package com.team2.service.impl;

import com.team2.dao.HomeDao;
import com.team2.entity.Person;
import com.team2.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeDao homeDao;

    @Override
    public List<Person> findAll() {
        return homeDao.findAllPersons();
    }
}
