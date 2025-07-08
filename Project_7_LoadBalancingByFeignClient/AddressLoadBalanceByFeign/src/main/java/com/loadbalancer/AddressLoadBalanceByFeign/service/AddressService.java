package com.loadbalancer.AddressLoadBalanceByFeign.service;

import com.loadbalancer.AddressLoadBalanceByFeign.model.Address;
import com.loadbalancer.AddressLoadBalanceByFeign.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    public AddressRepo addressRepo;

    public Optional<Address> getAddressById(int id) {
        return addressRepo.findById(id);
    }
}
