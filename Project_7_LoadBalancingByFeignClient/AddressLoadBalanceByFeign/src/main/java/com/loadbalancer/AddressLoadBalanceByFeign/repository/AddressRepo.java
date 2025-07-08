package com.loadbalancer.AddressLoadBalanceByFeign.repository;

import com.loadbalancer.AddressLoadBalanceByFeign.model.Address;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Integer> {
}
