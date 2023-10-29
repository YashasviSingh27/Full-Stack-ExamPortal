package com.exam.examserver.service;

import com.exam.models.User;
import com.exam.models.User_Role;

import java.util.Set;

public interface UserService {

    // creating user
    public User createUser(User user, Set<User_Role> UserRoles) throws Exception;

    // get user by username
    public User getUser(String username);

    // delete the user by id
    public void deleteUser(Long userId);
}
