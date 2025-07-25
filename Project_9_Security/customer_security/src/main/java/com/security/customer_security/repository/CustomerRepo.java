package com.security.customer_security.repository;

import com.security.customer_security.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    Optional<Customer> findByUsername(String username);
}
