package com.Elizabeth.eccomerceStore1.serviceImplimentation;

import com.Elizabeth.eccomerceStore1.DTO.AdminDTO;
import com.Elizabeth.eccomerceStore1.entitites.Admin;
import com.Elizabeth.eccomerceStore1.repositories.AdminRepository;
import com.Elizabeth.eccomerceStore1.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl  implements AdminService {

        @Autowired
        AdminRepository adminRepository;

    @Override
    public Admin findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    @Override
    public Admin save(AdminDTO admindto) {
        Admin admin = new Admin();
        admin.setFirstName(admindto.getFirstName());
        admin.setLastName(admindto.getLastName());
        admin.setUsername(admindto.getUsername());
        admin.setPassword(admindto.getPassword());
        return adminRepository.save(admin);
    }
}
