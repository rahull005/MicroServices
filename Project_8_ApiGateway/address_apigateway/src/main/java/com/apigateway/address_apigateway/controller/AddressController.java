package com.apigateway.address_apigateway.controller;

import com.apigateway.address_apigateway.model.Address;
import com.apigateway.address_apigateway.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping("/get/{id}")
    public Optional<Address> getAdderssbyId(@PathVariable int id){
        return addressService.getAddressById(id);
    }
}
