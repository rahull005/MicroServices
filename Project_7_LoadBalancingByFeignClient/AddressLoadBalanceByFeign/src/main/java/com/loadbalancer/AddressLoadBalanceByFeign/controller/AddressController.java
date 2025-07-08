package com.loadbalancer.AddressLoadBalanceByFeign.controller;

import com.loadbalancer.AddressLoadBalanceByFeign.model.Address;
import com.loadbalancer.AddressLoadBalanceByFeign.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping("/get/{id}")
    public Optional<Address> getAddressById(@PathVariable int id){
        return addressService.getAddressById(id);
    }
}
