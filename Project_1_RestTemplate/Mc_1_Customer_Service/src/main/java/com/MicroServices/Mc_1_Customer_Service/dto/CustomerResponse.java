package com.MicroServices.Mc_1_Customer_Service.dto;

import lombok.Data;

@Data
public class CustomerResponse {
    private int id;
    private String username;
    private String email;
    private AddressResponse addressResponse;
}
