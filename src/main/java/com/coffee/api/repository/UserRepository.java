package com.coffee.api.repository;


import com.coffee.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // login
    boolean existsByEmailAddress(String emailAddress);

    // register
    User findUserByEmailAddress(String emailAddress);
}
