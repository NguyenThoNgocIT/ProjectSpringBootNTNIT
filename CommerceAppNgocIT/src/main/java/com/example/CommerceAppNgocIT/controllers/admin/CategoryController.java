package com.example.CommerceAppNgocIT.controllers.admin;

import com.example.CommerceAppNgocIT.models.Category;
import com.example.CommerceAppNgocIT.models.ProductModel;
import com.example.CommerceAppNgocIT.services.CategoryService;
import com.example.CommerceAppNgocIT.services.ProductService;
import com.example.CommerceAppNgocIT.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private StorageService storageService;

    @Autowired
   private ProductService productService;

    @RequestMapping("/category")
    public String index(Model model) {
        List<Category> listCategory= this.categoryService.getAll();
        model.addAttribute("listCategory",listCategory);
     return "admin/category/index";
    }
@RequestMapping("add-category")
    public String add(Model model) {
    Category category = new Category();
    model.addAttribute("category",category);

    List<ProductModel> ListCate= this.productService.getAll();
    model.addAttribute("ListCate",ListCate);
        return "admin/category/add";
}
@PostMapping("/add-category") /// no lay tu cai input cua category add.html "fileImage
    public String save(@ModelAttribute("category") Category category, @RequestParam("fileImage") MultipartFile file) {
    ///upload file
    this.storageService.store(file);
    String fileName = file.getOriginalFilename();//luu vao dâtabase thì phai can co them cai ten nx
    category.setImage(fileName);
    if (this.categoryService.create(category)) {
        return "redirect:/admin/category";
//        return ResponseEntity.ok(category);
    }
        return "redirect:/admin/category";
//    return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
}
    @GetMapping("/edit-category/{id}")
    public String edit (Model model,@PathVariable("id") int id) {
        Category category = this.categoryService.findById(id);
        model.addAttribute("category", category);
        return "admin/category/edit";
    }
    @PostMapping("edit-category")
    public String update(@ModelAttribute("category") Category category, Model model) {
        if (this.categoryService.update(category)) {
            return "redirect:/admin/category";
        }else {
            return "admin/category/add";
        }
    }
    @GetMapping("delete-category/{id}")
    public String delete(@PathVariable("id") int id) {
        if (this.productService.deleteById(id)){
            return "redirect:/admin/category";
        }else{
            return "admin/category/add";
        }
    }
}
