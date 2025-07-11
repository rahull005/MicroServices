package com.apigateway.Customer_apigateway.repository;

import com.apigateway.Customer_apigateway.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
