package com.smlee.AccountApp.controller;

import com.smlee.AccountApp.entity.User;
import com.smlee.AccountApp.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository _userRepository) {
        this.userRepository = _userRepository;
    }

    @PostMapping
    public User createUser(@RequestBody User _user) {
        return userRepository.save(_user);
    }

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
