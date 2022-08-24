package com.Elizabeth.eccomerceStore1.controller.UserController;

import com.Elizabeth.eccomerceStore1.repositories.ProductRepository;
import com.Elizabeth.eccomerceStore1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    ProductRepository productRepository;


}
