package com.MicroServices.Mc_2_Customer_Service_Wc.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "microserv1_customertable")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String email;
}
