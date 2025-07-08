package com.microservices.Address_LoadBalacingByAnnotation.repository;
import com.microservices.Address_LoadBalacingByAnnotation.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Integer> {
}
