package com.MicroServices.Mc_1_Customer_Service.repository;

import com.MicroServices.Mc_1_Customer_Service.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
