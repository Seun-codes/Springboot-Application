package com.Elizabeth.eccomerceStore1.controller.Admin;

import com.Elizabeth.eccomerceStore1.DTO.AdminDTO;
import com.Elizabeth.eccomerceStore1.DTO.ProductDto;
import com.Elizabeth.eccomerceStore1.entitites.Admin;
import com.Elizabeth.eccomerceStore1.entitites.Product;
import com.Elizabeth.eccomerceStore1.entitites.User;
import com.Elizabeth.eccomerceStore1.exception.CustomAppException;
import com.Elizabeth.eccomerceStore1.repositories.ProductRepository;
import com.Elizabeth.eccomerceStore1.service.AdminService;
import com.Elizabeth.eccomerceStore1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class LoginProductController {
    @Autowired
  private AdminService adminService;

    @Autowired
    ProductService productService;

  @ModelAttribute("admin")
  public AdminDTO adminDTO(){
    return new AdminDTO();
  }


    @GetMapping("/AdminHome")
    public String AdminHome(@ModelAttribute String email){
        return "AdminHome";
    }


    @GetMapping("/AdminLogin")
    public ModelAndView loginForm(){
      ModelAndView mav = new ModelAndView("AdminLogin");
      mav.addObject("admin", new Admin());
      return mav;
    }

  @PostMapping("/AdminLogin")
  public ModelAndView login(@ModelAttribute("user") User user){
    Admin authAdmin = adminService.login(user.getEmail(), user.getPassword());
    if(authAdmin !=null){
      ModelAndView mav1 = new ModelAndView("AdminHome");
      mav1.addObject("user",authAdmin);
      mav1.addObject("email",user.getEmail());
      return mav1;
    }else{
      return new ModelAndView("AdminSignUp");
    }

  }



}
