package com.Loadbalacing.Customer_byRestT.dto;

import lombok.Data;

@Data
public class AddressResponse {
    private int id;
    private String village;
    private String city;
    private String postal;
}
