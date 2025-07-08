package com.Loadbalacing.Address_byRestT.repository;

import com.Loadbalacing.Address_byRestT.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address,Integer> {
}
