package com.Elizabeth.eccomerceStore1.service;

import com.Elizabeth.eccomerceStore1.DTO.AdminDTO;
import com.Elizabeth.eccomerceStore1.entitites.Admin;

public interface AdminService {
    Admin findByUsername(String username);

    Admin save(AdminDTO admindto);
}
