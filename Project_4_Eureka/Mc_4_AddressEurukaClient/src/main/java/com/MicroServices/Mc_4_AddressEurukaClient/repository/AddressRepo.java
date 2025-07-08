package com.MicroServices.Mc_4_AddressEurukaClient.repository;

import com.MicroServices.Mc_4_AddressEurukaClient.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Integer> {
}
