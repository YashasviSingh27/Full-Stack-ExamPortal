package com.exam.examserver.controller;

import com.exam.examserver.models.User_Role;
import com.exam.examserver.service.UserService;
import com.exam.examserver.models.Role;
import com.exam.examserver.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.HashSet;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    // creating user
    @PostMapping("/")
    public User createUser(@RequestBody User user) throws Exception{
        Set<User_Role> roles = new HashSet<>();
        Role role = new Role();
        role.setRoleName("NORMAL");
        role.setRoleId(45L);

        User_Role userRole = new User_Role();
        userRole.setUser(user);
        userRole.setRole(role);
        roles.add(userRole);
        return userService.createUser(user, roles);
    }

    @GetMapping("/find/{username}")
    public User getUser(@PathVariable("username") String username) throws Exception {
        User user = userService.getUser(username);
        if(user == null)
        {
            throw new Exception(username + " not found");
        }
        return user;
    }

    // delete user by id
    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){
        this.userService.deleteUser(userId);
    }

}
