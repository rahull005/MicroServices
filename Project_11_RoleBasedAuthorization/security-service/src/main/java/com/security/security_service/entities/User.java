package com.security.security_service.entities;

import com.security.security_service.roles.Role;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "p11_users_RoleBased")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq",sequenceName = "seq",allocationSize = 1)
    private int id;
    private String username;
    private String password;
    private String email;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "P11_USER_ROLES_AUTHORIZAITON",joinColumns = @JoinColumn(name = "User_Id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private List<Role> roles;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
