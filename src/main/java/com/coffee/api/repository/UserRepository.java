package com.coffee.api.repository;


import com.coffee.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // login
    boolean existsByEmail(String email);

    // register
    User findUserByEmail(String email);
}
