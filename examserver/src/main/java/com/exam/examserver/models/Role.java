package com.exam.examserver.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long role_Id;
    private String role_name;

    public Role(Long role_Id, String role_name) {
        this.role_Id = role_Id;
        this.role_name = role_name;
    }

    // mapping with User_role
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "role")
    private Set<User_Role> userRoles = new HashSet<>();

    public Set<User_Role> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<User_Role> userRoles) {
        this.userRoles = userRoles;
    }

    public Role() {
    }

    public Long getRole_Id() {
        return role_Id;
    }

    public void setRole_Id(Long role_Id) {
        this.role_Id = role_Id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
