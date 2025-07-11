package com.apigateway.address_apigateway.repository;

import com.apigateway.address_apigateway.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Integer> {
}
