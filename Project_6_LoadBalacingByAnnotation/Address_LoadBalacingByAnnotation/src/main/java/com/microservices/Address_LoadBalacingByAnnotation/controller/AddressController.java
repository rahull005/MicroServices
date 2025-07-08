package com.microservices.Address_LoadBalacingByAnnotation.controller;

import com.microservices.Address_LoadBalacingByAnnotation.model.Address;
import com.microservices.Address_LoadBalacingByAnnotation.sercvice.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class AddressController {

    @Autowired
    AddressService service;

    @PostMapping("/add")
    public Address addAdress(@RequestBody Address address){
        return service.addAddress(address);
    }

    @GetMapping("/get/{id}")
    public Address getAddressbyId(@PathVariable int id) {
        System.out.println("Fetching address for ID: " + id);
        return service.getAddressById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Address not found"));
    }


}
