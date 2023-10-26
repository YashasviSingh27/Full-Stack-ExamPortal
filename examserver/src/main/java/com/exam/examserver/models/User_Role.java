package com.exam.examserver.models;

import jakarta.persistence.*;

@Entity
public class User_Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long userRoleId;

    // user
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @ManyToOne
    private Role role;

    public User_Role() {
    }

    public User_Role(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}
