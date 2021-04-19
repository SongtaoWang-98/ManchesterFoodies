package com.team2.controller;

import com.team2.form.AddressForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:springmvc.xml","classpath:mybatisConfig.xml","classpath:spring.xml"})
public class AddressControllerTest {

    @Autowired
    AddressController addressController;

    @Test
    public void addAddressTest() {
        AddressForm addressForm = new AddressForm();
        addressForm.setUserId(1);
        addressForm.setAddress("1111fdafa");
        addressForm.setPostcode("kdasfd");
        addressForm.setTel("102038");
        addressController.addToAddress(addressForm);
    }

}