package com.example.CommerceAppNgocIT.controllers;

import com.example.CommerceAppNgocIT.models.ProductModel;
import com.example.CommerceAppNgocIT.repositorys.ProductRepository;
import com.example.CommerceAppNgocIT.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/products")
    public String ShowProducts(Model model) {
        List<ProductModel> list = this.productService.getAll();
        model.addAttribute("products", list);

       return "admin/products/index";
   }
    @GetMapping("/add-product")
    public String AddProduct(Model model) {
       ProductModel product = new ProductModel();
       /// lấy từ cái form của model
        model.addAttribute("product",product);
       return "admin/products/add";
    }
@PostMapping("/add-product")
/// lấy từ cái form của model
    public String save(@ModelAttribute("product") ProductModel product, Model model) {
        /// neu hop le thi tra ve trang product con k hop le thi ve trang add lai
        if (this.productService.create(product)) {
            return "redirect:/admin/products";
        } else{
            return "admin/products/add";
        }
}
    @GetMapping("/edit-product/{id}")
    public String edit (Model model,@PathVariable("id") int id) {
        ProductModel product = this.productService.findById(id);
        model.addAttribute("product", product);
        return "admin/products/edit";
    }
    @PostMapping("edit-product")
    public String update(@ModelAttribute("product") ProductModel product, Model model) {
        if (this.productService.update(product)) {
            return "redirect:/admin/products";
        }else {
            return "admin/products/add";
        }
    }
@GetMapping("delete-product/{id}")
    public String delete(@PathVariable("id") int id) {
    if (this.productService.deleteById(id)){
        return "redirect:/admin/products";
    }else{
        return "admin/products/add";
    }
}
}
