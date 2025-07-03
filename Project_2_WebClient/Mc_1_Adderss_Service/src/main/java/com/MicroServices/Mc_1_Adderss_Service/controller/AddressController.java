package com.MicroServices.Mc_1_Adderss_Service.controller;

import com.MicroServices.Mc_1_Adderss_Service.model.Address;
import com.MicroServices.Mc_1_Adderss_Service.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AddressController {
    @Autowired
    AddressService service;

    @PostMapping("/add")
    public Address addAddress(@RequestBody Address address){
        return service.addAddress(address);
    }

    @GetMapping("/get/{id}")
    public Optional<Address> getAddressbyId(@PathVariable int id){

        return service.getAddress(id);
    }
}
