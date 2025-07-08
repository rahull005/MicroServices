package com.MicroServices.Mc_1_Adderss_Service.repository;

import com.MicroServices.Mc_1_Adderss_Service.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Integer> {
}
