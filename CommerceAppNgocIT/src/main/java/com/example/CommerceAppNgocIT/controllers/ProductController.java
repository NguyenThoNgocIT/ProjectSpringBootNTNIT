package com.example.CommerceAppNgocIT.controllers;

import org.springframework.ui.Model;
import com.example.CommerceAppNgocIT.models.ProductModel;
import com.example.CommerceAppNgocIT.repositorys.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller

public class ProductController {
    @RequestMapping("admin/products")
    public String ShowProducts() {

       return "admin/products/index";
   }
    @RequestMapping("admin/add-product")
    public String AddProduct() {

       return "admin/products/add";
    }


}
