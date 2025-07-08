package com.microservices.Address_LoadBalacingByAnnotation.sercvice;

import com.microservices.Address_LoadBalacingByAnnotation.model.Address;
import com.microservices.Address_LoadBalacingByAnnotation.repository.AddressRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class AddressService {

    @Autowired
    AddressRepo addressRepo;

    public Address addAddress(Address address) {
        log.info(String.valueOf(address));
        return addressRepo.save(address);
    }

    public Optional<Address> getAddressById(int id) {
        return Optional.of(addressRepo.findById(id).get());
    }
}
