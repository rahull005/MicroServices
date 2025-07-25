package com.security.customer_security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {

    private int id;
    private String username;
    private String email;
    private AddressResponse addressResponse;

}
