package com.Loadbalacing.Customer_byRestT.repository;

import com.Loadbalacing.Customer_byRestT.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
