package com.apigateway.address_apigateway.service;

import com.apigateway.address_apigateway.model.Address;
import com.apigateway.address_apigateway.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressRepo repo;

    public Optional<Address> getAddressById(int id) {
        return repo.findById(id);
    }
}
