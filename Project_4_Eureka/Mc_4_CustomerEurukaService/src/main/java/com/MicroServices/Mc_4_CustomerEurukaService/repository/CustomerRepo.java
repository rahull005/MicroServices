package com.MicroServices.Mc_4_CustomerEurukaService.repository;

import com.MicroServices.Mc_4_CustomerEurukaService.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
