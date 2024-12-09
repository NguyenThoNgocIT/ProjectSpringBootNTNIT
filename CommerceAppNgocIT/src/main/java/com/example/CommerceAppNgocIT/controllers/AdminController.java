package com.example.CommerceAppNgocIT.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping({"","/"})
public String ShowAdmin () {
    return "admin/index";
}

}
