package com.security.address_security.service;

import com.security.address_security.entity.Address;
import com.security.address_security.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    AddressRepo addressRepo;

    public Address getAddressById(int id) {
        return addressRepo.findById(id).orElseThrow(()->new RuntimeException("Address not Found Exception with the following di"));
    }
}
