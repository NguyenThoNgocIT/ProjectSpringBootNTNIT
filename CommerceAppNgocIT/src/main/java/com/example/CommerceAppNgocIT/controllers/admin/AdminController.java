package com.example.CommerceAppNgocIT.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping
    public String redirectToAdminHome() {
        // Redirect từ /admin sang /admin/
        return "redirect:/admin/";
    }

    @GetMapping("/")
    public String showAdminPage() {
        // Trả về view admin/index
        return "admin/index";
    }
}
