package com.coffee.api.service;

import com.coffee.api.exception.InformationExistException;
import com.coffee.api.model.User;
import com.coffee.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, @Lazy PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // creates user
    public User createUser(User userObject) {
        if (!userRepository.existsByEmail(userObject.getEmail())) {
            userObject.setPassword(passwordEncoder.encode(userObject.getPassword()));
            return userRepository.save(userObject);
        } else {
            throw new InformationExistException("user with email address " + userObject.getEmail() +
                    " already exists");
        }
    }

    // finds user by email address
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
