package com.Elizabeth.eccomerceStore1.controller.UserController;

import com.Elizabeth.eccomerceStore1.entitites.Cart;
import com.Elizabeth.eccomerceStore1.entitites.CartItem;
import com.Elizabeth.eccomerceStore1.entitites.Product;
import com.Elizabeth.eccomerceStore1.entitites.User;
import com.Elizabeth.eccomerceStore1.repositories.ProductRepository;
import com.Elizabeth.eccomerceStore1.service.CartService;
import com.Elizabeth.eccomerceStore1.service.ProductService;
import com.Elizabeth.eccomerceStore1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;








    @PostMapping("/Home")
    public ModelAndView viewProducts(@ModelAttribute String email, Model model){
        List<Product> productsList = productRepository.findAll();
        model.addAttribute("products", productsList);
        ModelAndView mav = new ModelAndView("Home");
        mav.addObject("productsList", productsList);
        mav.addObject("email", email);
        return mav;

    }

    @GetMapping("/customerViewProducts")
    public ModelAndView customerViewProducts(@ModelAttribute String email) {
        List<Product> listOfProducts = productRepository.findAll();
        ModelAndView mav = new ModelAndView("Home");
        mav.addObject("listOfProducts", listOfProducts);
        mav.addObject("email", email);
        return mav;
    }












}
