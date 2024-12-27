package com.example.CommerceAppNgocIT.services.Impl;

import com.example.CommerceAppNgocIT.models.ProductModel;
import com.example.CommerceAppNgocIT.repositorys.ProductRepository;
import com.example.CommerceAppNgocIT.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<ProductModel> getAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Boolean create(ProductModel product) {
        try{
            this.productRepository.save(product);/// phuong thuc save no se tra ve mot product
            return true;
        }
        catch (Exception e)
        {
       e.printStackTrace();
        }
        return false;
    }

    @Override
    public ProductModel findById(Integer id) {
        return this.productRepository.findById(id).get();
    }

    @Override
    public Boolean update(ProductModel product) {
        try{
            this.productRepository.save(product);/// phuong thuc save no se tra ve mot product
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean deleteById(Integer id) {
        try {
            this.productRepository.delete(findById(id));
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
return false;
    }

    @Override
    public List<ProductModel> searchProduct(String keyword) {
        return this.productRepository.searchProduct(keyword);
    }
}
