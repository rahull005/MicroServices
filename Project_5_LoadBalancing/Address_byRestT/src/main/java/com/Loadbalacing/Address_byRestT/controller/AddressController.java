package com.Loadbalacing.Address_byRestT.controller;


import com.Loadbalacing.Address_byRestT.model.Address;
import com.Loadbalacing.Address_byRestT.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/address")
@Slf4j
public class AddressController {
    @Autowired
    AddressService service;

    @PostMapping("/add")
    public Address addAddress(@RequestBody Address address){
        return service.addAddress(address);
    }

    @GetMapping("/get/{id}")
    public Optional<Address> getAddressbyId(@PathVariable int id){
      log.info("called");
        return service.getAddress(id);
    }
}