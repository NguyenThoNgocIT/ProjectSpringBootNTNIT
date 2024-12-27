package com.example.CommerceAppNgocIT.services;

import com.example.CommerceAppNgocIT.models.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Boolean create(Category category) ;
    Category findById(Integer id );
    Boolean update(Category category);
    Boolean deleteById(Integer id);
}
