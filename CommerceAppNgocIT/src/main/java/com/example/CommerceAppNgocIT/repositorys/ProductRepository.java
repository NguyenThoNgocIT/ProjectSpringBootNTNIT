package com.example.CommerceAppNgocIT.repositorys;

import com.example.CommerceAppNgocIT.models.ProductModel;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductModel,Integer> {
}
