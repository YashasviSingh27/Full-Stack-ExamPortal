package com.exam.examserver.models;

import jakarta.persistence.*;

@Entity
public class User_Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long user_RoleId;

    // user
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne
    private Role role;

    public User_Role() {
    }

    public User_Role(Long user_RoleId) {
        this.user_RoleId = user_RoleId;
    }
}
