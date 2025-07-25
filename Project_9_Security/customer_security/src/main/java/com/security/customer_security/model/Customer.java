package com.security.customer_security.model;

import com.security.customer_security.Roles.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "microserv9_custSecurity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust_seq")
    @SequenceGenerator(name = "cust_seq", sequenceName = "cust_seq", allocationSize = 1)
    private int id;
    private String username;
    private String password;
    private String email;
    @ElementCollection(fetch = FetchType.EAGER)  //telling to Jpa that we are storing collections which are non-entity type..when we usually store we use map and that to between entities
    @CollectionTable(
            name = "user_roles_mc_security",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @Enumerated(EnumType.STRING)
    public List<Role> roles;

}




/*
@ElementCollection	            =  Tells JPA you're storing a collection of non-entity types
@CollectionTable	            =  Specifies the table name (user_roles) and the join column (user_id)
@Enumerated(EnumType.STRING)    = Stores enum as a string in DB, not as an ordinal number
@Column(name = "role")	        = Specifies the column name in the user_roles table
 */