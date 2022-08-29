package com.Elizabeth.eccomerceStore1.controller.UserController;

import com.Elizabeth.eccomerceStore1.entitites.User;
import com.Elizabeth.eccomerceStore1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class loginController {
    @Autowired
    private UserService userService;


    @GetMapping({"/Login"})
    public ModelAndView loginForm(){
        ModelAndView mav = new ModelAndView("Login");
        mav.addObject("user", new User());
        return mav;
    }

    @GetMapping({"/index"})
    public ModelAndView indexPage(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("user", new User());
        return mav;
    }

    @PostMapping("/Login")
   public ModelAndView login(@ModelAttribute("user") User user){
        User authUser = userService.Login(user.getEmail(), user.getPassword());
        if(authUser !=null){
            ModelAndView mav1 = new ModelAndView("index");
            mav1.addObject("user",authUser);
            mav1.addObject("email",user.getEmail());
            return mav1;
        }else{
            return new ModelAndView("SignUp");
        }

    }






}
