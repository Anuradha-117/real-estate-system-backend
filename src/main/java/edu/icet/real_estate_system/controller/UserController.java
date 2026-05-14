package edu.icet.real_estate_system.controller;

import edu.icet.real_estate_system.entity.UserEntity;
import edu.icet.real_estate_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public UserEntity register(@RequestBody UserEntity user) {
        return service.registerUser(user);
    }

    @PostMapping("/login")
    public UserEntity login(@RequestBody UserEntity credentials) {
        return service.loginUser(credentials.getEmail(), credentials.getPassword());
    }
}