package com.team2.service.impl;

import com.team2.dao.AddressInfoDao;
import com.team2.entity.AddressInfo;
import com.team2.enums.StatusCode;
import com.team2.form.AddressForm;
import com.team2.service.AddressService;
import com.team2.util.ResultVOUtil;
import com.team2.vo.AddressVO;
import com.team2.vo.AddressesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressInfoDao addressInfoDao;

    @Override
    public StatusCode addAddress(AddressForm addressForm) {
        AddressInfo addressInfo = new AddressInfo();
        addressInfo.setUserId(addressForm.getUserId());
        addressInfo.setName(addressForm.getName());
        addressInfo.setAddress(addressForm.getAddress());
        addressInfo.setPostcode(addressForm.getPostcode());
        addressInfo.setAddressTel(addressForm.getTel());
        addressInfoDao.save(addressInfo);
        return StatusCode.SUCCESS;
    }

    @Override
    public StatusCode deleteAddress(Integer addressId) {
        addressInfoDao.deleteByAddressId(addressId);
        return StatusCode.SUCCESS;
    }

    @Override
    public AddressesVO viewAddresses(Integer userId) {
        List<AddressVO> addressVOList = new ArrayList<>();
        List<AddressInfo> addressInfoList = addressInfoDao.findAllByUserId(userId);
        for(AddressInfo addressInfo: addressInfoList) {
            addressVOList.add(new AddressVO(
                    addressInfo.getAddressId(),
                    addressInfo.getName(),
                    addressInfo.getAddress(),
                    addressInfo.getPostcode(),
                    addressInfo.getAddressTel()
            ));
        }
        return new AddressesVO(addressVOList);
    }
}
