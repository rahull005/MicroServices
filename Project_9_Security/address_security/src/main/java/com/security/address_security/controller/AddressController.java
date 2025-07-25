package com.security.address_security.controller;

import com.security.address_security.entity.Address;
import com.security.address_security.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("/get/{id}")
    public Address getAddressbyId(@PathVariable int id){
        return addressService.getAddressById(id);
    }
}
