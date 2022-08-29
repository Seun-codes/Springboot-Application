package com.Elizabeth.eccomerceStore1.controller.UserController;

import com.Elizabeth.eccomerceStore1.DTO.UserDto;
import com.Elizabeth.eccomerceStore1.entitites.User;
import com.Elizabeth.eccomerceStore1.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Objects;

@Controller
@RequestMapping("/SignUp")
public class UserRegController {
    private UserService userService;

    public UserRegController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserDto userDto(){
        return new UserDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "SignUp";
    }


    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserDto userDto) {
        userService.create(userDto);
        return "redirect:/SignUp?success";
    }






}
