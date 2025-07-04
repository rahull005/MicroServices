package com.Loadbalacing.Address_byRestT.service;


import com.Loadbalacing.Address_byRestT.model.Address;
import com.Loadbalacing.Address_byRestT.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    AddressRepo repo;

    public Optional<Address> getAddress(int id){
        return repo.findById(id);
    }

    public Address addAddress(Address address){
        return repo.save(address);
    }
}

