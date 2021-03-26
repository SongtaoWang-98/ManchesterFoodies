package com.team2.dao;

import com.team2.entity.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface HomeDao {
    public List<Person> findAllPersons();
}
