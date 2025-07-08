package com.MicroServices.Mc_1_Adderss_Service.service;

import com.MicroServices.Mc_1_Adderss_Service.model.Address;
import com.MicroServices.Mc_1_Adderss_Service.repository.AddressRepo;
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
