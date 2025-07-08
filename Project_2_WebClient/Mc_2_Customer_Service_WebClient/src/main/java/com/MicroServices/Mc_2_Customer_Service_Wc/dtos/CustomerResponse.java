package com.MicroServices.Mc_2_Customer_Service_Wc.dtos;

import lombok.Data;

@Data
public class CustomerResponse {
    private int id;
    private String username;
    private String email;
    private AddressResponse addressResponse;
}
