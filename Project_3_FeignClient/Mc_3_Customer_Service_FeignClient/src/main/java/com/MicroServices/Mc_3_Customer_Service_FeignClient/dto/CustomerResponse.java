package com.MicroServices.Mc_3_Customer_Service_FeignClient.dto;

import lombok.Data;

@Data
public class CustomerResponse {
    private int id;
    private String username;
    private String email;
    AddressResponse addressResponse;
}