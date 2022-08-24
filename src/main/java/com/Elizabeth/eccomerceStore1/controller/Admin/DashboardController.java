package com.Elizabeth.eccomerceStore1.controller.Admin;

import com.Elizabeth.eccomerceStore1.repositories.AdminRepository;
import com.Elizabeth.eccomerceStore1.repositories.ProductRepository;
import com.Elizabeth.eccomerceStore1.service.AdminService;
import com.Elizabeth.eccomerceStore1.service.ProductService;
import com.Elizabeth.eccomerceStore1.serviceImplimentation.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class DashboardController {
    @Autowired
  private AdminService adminService;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/AdminHome")
    public String home(@ModelAttribute String email){
        return "AdminHome";
    }


}
