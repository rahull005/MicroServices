package com.microservices.Customer_LoadBalacingByAnnotation.repository;

import com.microservices.Customer_LoadBalacingByAnnotation.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
