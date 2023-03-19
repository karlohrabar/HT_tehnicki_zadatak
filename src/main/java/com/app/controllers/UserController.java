package com.app.controllers;

import com.app.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.app.services.UserService;


@RestController
@CrossOrigin(origins = "http://localhost:8080")

public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public String createUser(@RequestBody Users user){
        return userService.createUser(user);
    }
}
