package com.example.CommerceAppNgocIT.repositorys;

import com.example.CommerceAppNgocIT.models.ProductModel;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductModel,Integer> {
@Query("SELECT c from ProductModel c WHERE c.ProductName like %?1%")
List<ProductModel> searchProduct(String keyword);
}
