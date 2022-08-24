package com.Elizabeth.eccomerceStore1.repositories;

import com.Elizabeth.eccomerceStore1.entitites.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByUsername(String username);

}
