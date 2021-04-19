package com.team2.service;

import com.team2.enums.StatusCode;
import com.team2.form.AddressForm;
import com.team2.vo.AddressesVO;

public interface AddressService {
    StatusCode addAddress(AddressForm addressForm);
    StatusCode deleteAddress(Integer addressId);
    AddressesVO viewAddresses(Integer userId);
}
