package com.Elizabeth.eccomerceStore1.repositories;

import com.Elizabeth.eccomerceStore1.entitites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);
}
