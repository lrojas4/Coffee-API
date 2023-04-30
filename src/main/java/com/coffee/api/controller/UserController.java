package com.coffee.api.controller;

import com.coffee.api.model.User;
import com.coffee.api.model.request.LoginRequest;
import com.coffee.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth/users/")
public class UserController {

    private UserService userService;

    @Autowired
    public void SetUserService(UserService userService) {
        this.userService = userService;
    }

    // creates User
    @PostMapping(path = "/register/")
    public User createUser(@RequestBody User userObject) {
        return userService.createUser(userObject);
    }

    // logins user
    @PostMapping("/login/")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        return userService.loginUser(loginRequest);
    }


}
