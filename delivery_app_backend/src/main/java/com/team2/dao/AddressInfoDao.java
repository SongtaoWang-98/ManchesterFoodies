package com.team2.dao;

import com.team2.entity.AddressInfo;

import java.util.List;

public interface AddressInfoDao {
    void save(AddressInfo addressInfo);
    void deleteByAddressId(Integer addressId);
    List<AddressInfo> findAllByUserId(Integer userId);
}
