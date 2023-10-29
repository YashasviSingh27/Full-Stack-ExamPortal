package com.exam.examserver.service.impl;

import com.exam.models.Role;
import com.exam.models.User;
import com.exam.models.User_Role;
import com.exam.examserver.repo.RoleRepository;
import com.exam.examserver.repo.UserRepository;
import com.exam.examserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

@Service
public class UserSeviceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    // creating user
    @Override
    public User createUser(User user, Set<User_Role> UserRoles) throws Exception {

        System.out.println("creating new user " + user.getUsername());
        User localUser = this.userRepository.findByUsername(user.getUsername());
        if(localUser == null) {
            UserRoles.forEach(ur -> {
                roleRepository.save(ur.getRole());
            });
            user.getUserRoles().addAll(UserRoles);
            return userRepository.save(user);
        }
        else {
            throw new Exception("User with username already exists!");
        }
    }

    // getting user by username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public void deleteUser(Long userId) {
        this.userRepository.deleteById(userId);
    }
}
