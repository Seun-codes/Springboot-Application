package com.Elizabeth.eccomerceStore1.serviceImplimentation;

import com.Elizabeth.eccomerceStore1.DTO.AdminDTO;
import com.Elizabeth.eccomerceStore1.DTO.ProductDto;
import com.Elizabeth.eccomerceStore1.entitites.Admin;
import com.Elizabeth.eccomerceStore1.entitites.Product;
import com.Elizabeth.eccomerceStore1.exception.CustomAppException;
import com.Elizabeth.eccomerceStore1.repositories.AdminRepository;
import com.Elizabeth.eccomerceStore1.repositories.ProductRepository;
import com.Elizabeth.eccomerceStore1.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl  implements AdminService {

        @Autowired
        AdminRepository adminRepository;
        @Autowired
        ProductRepository productRepository;

    @Override
    public Admin findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    @Override
    public Admin save(AdminDTO admindto) {
        Admin admin = new Admin();
        admin.setEmail(admindto.getEmail());
        admin.setFirstName(admindto.getFirstName());
        admin.setLastName(admindto.getLastName());
        admin.setUsername(admindto.getUsername());
        admin.setPassword(admindto.getPassword());
        return adminRepository.save(admin);
    }

    @Override
    public Admin login(String email, String password) {
        Admin admin = adminRepository.findByEmailAndPassword(email,password);
        return admin;
    }

    @Override
    public Product createProducts(ProductDto productDto) {

        Product product = new Product();

        product.setName(productDto.getName());
        product.setCategory(productDto.getCategory());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());
        product.setImage(productDto.getImage());

        return productRepository.save(product);
    }

    @Override
    public Product UpdateProducts(Product product, Long id) {
        Product product1 = productRepository.findByProductId(id);
        product1.setName(product.getName());
        product1.setCategory(product.getCategory());
        product1.setPrice(product.getPrice());

        return productRepository.save(product1);
    }


}
