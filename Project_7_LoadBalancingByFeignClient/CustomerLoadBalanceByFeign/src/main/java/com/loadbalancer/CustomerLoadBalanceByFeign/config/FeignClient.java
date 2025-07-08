package com.loadbalancer.CustomerLoadBalanceByFeign.config;

import com.loadbalancer.CustomerLoadBalanceByFeign.dtos.AddressResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.cloud.openfeign.FeignClient(name="AddressLoadBalanceByFeign")
public interface FeignClient {
    @GetMapping("/get/{id}")
    public AddressResponse addressResponse(@PathVariable int id);
}
