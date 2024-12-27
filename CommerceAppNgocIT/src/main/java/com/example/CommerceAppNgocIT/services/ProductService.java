package com.example.CommerceAppNgocIT.services;

import com.example.CommerceAppNgocIT.models.ProductModel;

import java.util.List;

//// CRUD product
public interface ProductService {
    List<ProductModel> getAll();
    Boolean create(ProductModel product);
    ProductModel findById(Integer id );
    Boolean update(ProductModel product);
    Boolean deleteById(Integer id);
    List<ProductModel> searchProduct(String keyword);

}
