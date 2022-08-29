package com.Elizabeth.eccomerceStore1.controller.CartController;

import com.Elizabeth.eccomerceStore1.entitites.Cart;
import com.Elizabeth.eccomerceStore1.entitites.CartItem;
import com.Elizabeth.eccomerceStore1.entitites.Product;
import com.Elizabeth.eccomerceStore1.entitites.User;
import com.Elizabeth.eccomerceStore1.service.CartService;
import com.Elizabeth.eccomerceStore1.service.ProductService;
import com.Elizabeth.eccomerceStore1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;


    @GetMapping("/Cart")
    public ModelAndView viewCart(@ModelAttribute String email) {
        List<CartItem> listOfProducts = userService.getCart(email);
        ModelAndView mav = new ModelAndView("Cart");
        mav.addObject("listOfProducts", listOfProducts);
        mav.addObject("email", email);
        return mav;
    }

    @PostMapping("/add-to-cart/")
    public String add(@RequestParam Long productId, @RequestParam int quantity) {
        Product product = productService.findProductById(productId);
        User users =new User();
        cartService.addItemToCart(product,quantity,users);
        return "redirect:/my-home";
    }



}
