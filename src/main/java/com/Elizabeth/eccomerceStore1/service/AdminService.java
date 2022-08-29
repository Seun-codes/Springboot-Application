package com.Elizabeth.eccomerceStore1.service;

import com.Elizabeth.eccomerceStore1.DTO.AdminDTO;
import com.Elizabeth.eccomerceStore1.DTO.ProductDto;
import com.Elizabeth.eccomerceStore1.entitites.Admin;
import com.Elizabeth.eccomerceStore1.entitites.Product;

public interface AdminService {
    Admin findByUsername(String username);

    Admin save(AdminDTO admindto);
    Admin login(String email, String password);

    Product createProducts(ProductDto productDto);
    Product UpdateProducts(Product product, Long id);
}
