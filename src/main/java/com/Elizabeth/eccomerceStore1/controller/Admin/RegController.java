package com.Elizabeth.eccomerceStore1.controller.Admin;

import com.Elizabeth.eccomerceStore1.DTO.AdminDTO;
import com.Elizabeth.eccomerceStore1.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/AdminSignUp")
public class RegController {

    private AdminService adminService;

    public RegController(AdminService adminService) {
        this.adminService = adminService;
    }

    @ModelAttribute("admin")
    public AdminDTO adminDTO(){
        return new AdminDTO();
    }

    @GetMapping
    public String showRegForm(Model model){
        AdminDTO admin = new AdminDTO();
        model.addAttribute("admin", admin);
        return "AdminSignUp";
    }

    @PostMapping
    public String adminReg(@ModelAttribute("admin") AdminDTO adminDTO){
        adminService.save(adminDTO);
        return "redirect:/AdminSignUp?success";
    }
}
