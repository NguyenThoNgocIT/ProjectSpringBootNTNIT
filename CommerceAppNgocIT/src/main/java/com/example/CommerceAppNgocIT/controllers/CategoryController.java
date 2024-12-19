package com.example.CommerceAppNgocIT.controllers;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class CategoryController {
    @RequestMapping("/category")
    public String index(Model model) {
        return "admin/category/index";
    }

}
