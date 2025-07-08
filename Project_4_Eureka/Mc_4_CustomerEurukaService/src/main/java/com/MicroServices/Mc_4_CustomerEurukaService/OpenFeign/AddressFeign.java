package com.MicroServices.Mc_4_CustomerEurukaService.OpenFeign;

import com.MicroServices.Mc_4_CustomerEurukaService.dto.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "feign", url = "http://localhost:8081")
public interface AddressFeign{
    @GetMapping("/get/{id}")
    AddressResponse addressResponse(@PathVariable int id);
}
