package com.example.CommerceAppNgocIT.services.Impl;

import com.example.CommerceAppNgocIT.models.Category;
import com.example.CommerceAppNgocIT.models.ProductModel;
import com.example.CommerceAppNgocIT.repositorys.CategoryRepository;
import com.example.CommerceAppNgocIT.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Boolean create(Category category) {
        try{
            this.categoryRepository.save(category);
            return true;
        }catch (Exception e){
          e.printStackTrace();
        }
        return false;
    }

    @Override
    public Category findById(Integer id) {
        return null;
    }

    @Override
    public Boolean update(Category category) {
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return null;
    }
}
