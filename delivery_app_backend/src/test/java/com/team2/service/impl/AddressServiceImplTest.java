package com.team2.service.impl;

import com.team2.form.AddressForm;
import com.team2.service.AddressService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springmvc.xml","classpath:mybatisConfig.xml","classpath:spring.xml"})
public class AddressServiceImplTest {

    @Autowired
    private AddressService addressService;

    @Test
    public void addAddressTest() {
        AddressForm addressForm = new AddressForm();
        addressForm.setUserId(1);
        addressForm.setName("babao");
        addressForm.setAddress("Manchester");
        addressForm.setPostcode("M156JG");
        addressForm.setTel("7577383747");
        addressService.addAddress(addressForm);
    }

    @Test
    public void deleteAddressTest() {
        addressService.deleteAddress(7);
    }

    @Test
    public void viewAddressTest() {
        System.out.println(addressService.viewAddresses(1));
    }
}