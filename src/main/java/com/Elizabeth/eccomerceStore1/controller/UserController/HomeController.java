package com.Elizabeth.eccomerceStore1.controller.UserController;

import com.Elizabeth.eccomerceStore1.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my-home")
public class HomeController {
    @Autowired
    private ProductRepository productRepository;

    public HomeController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public String showHomePage(Model model){
        model.addAttribute("homeProducts", productRepository.findAll());
        return "Home";
    }


}
