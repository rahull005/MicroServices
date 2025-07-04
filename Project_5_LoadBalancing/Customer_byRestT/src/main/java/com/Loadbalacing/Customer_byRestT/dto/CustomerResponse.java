package com.Loadbalacing.Customer_byRestT.dto;

import lombok.Data;

@Data
public class CustomerResponse {
    private int id;
    private String username;
    private String email;
    AddressResponse addressResponse;
}