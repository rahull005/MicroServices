package com.MicroServices.Mc_3_Customer_Service_FeignClient.repository;

import com.MicroServices.Mc_3_Customer_Service_FeignClient.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
