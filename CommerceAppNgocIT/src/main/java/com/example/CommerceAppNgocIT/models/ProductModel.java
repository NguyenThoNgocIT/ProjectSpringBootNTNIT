package com.example.CommerceAppNgocIT.models;

import jakarta.persistence.*;

@Entity
@Table(name="products")
public class ProductModel {
    @Id
    @Column(name="productId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name="productName")
    private String ProductName;
    @Column(name="productStatus")
    private Boolean ProductStatus;

    public ProductModel() {


    }

    public ProductModel(int productId, String productName, Boolean productStatus) {
        Id = productId;
        ProductName = productName;
        ProductStatus = productStatus;
    }

    public int getProductId() {
        return Id;
    }

    public void setProductId(int productId) {
              Id = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public Boolean getProductStatus() {
        return ProductStatus;
    }

    public void setProductStatus(Boolean productStatus) {
        ProductStatus = productStatus;
    }
}

