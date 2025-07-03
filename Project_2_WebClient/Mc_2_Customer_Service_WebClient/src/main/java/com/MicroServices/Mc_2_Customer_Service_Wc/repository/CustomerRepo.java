package com.MicroServices.Mc_2_Customer_Service_Wc.repository;

import com.MicroServices.Mc_2_Customer_Service_Wc.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
