package com.loadbalancer.CustomerLoadBalanceByFeign.repository;

import com.loadbalancer.CustomerLoadBalanceByFeign.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
