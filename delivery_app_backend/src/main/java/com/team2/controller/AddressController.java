package com.team2.controller;

import com.team2.form.AddressForm;
import com.team2.service.AddressService;
import com.team2.util.ResultVOUtil;
import com.team2.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/add")
    public ResultVO addToAddress(@RequestBody AddressForm addressForm) {
        return ResultVOUtil.success(addressService.addAddress(addressForm));
    }

    @PutMapping("/delete")
    public ResultVO deleteAddress(Integer addressId) {
        return ResultVOUtil.success(addressService.deleteAddress(addressId));
    }

    @GetMapping
    public ResultVO viewAddresses(Integer userId) {
        return ResultVOUtil.success(addressService.viewAddresses(userId));
    }

}
