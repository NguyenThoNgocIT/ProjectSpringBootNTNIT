package com.example.CommerceAppNgocIT.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="products")
public class ProductModel {
    @Id
    @Column(name = "productId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ProductId;
    @Column(name = "productName")
    private String ProductName;
    @Column(name = "productStatus")
    private Boolean ProductStatus;
    // Quan hệ OneToMany từ ProductModel đến Category
    @OneToMany(mappedBy = "productModel", fetch = FetchType.EAGER)
    private Set<Category> categories;

    public ProductModel() {


    }

    public ProductModel(int productId, String productName, Boolean productStatus) {
        ProductId = productId;
        ProductName = productName;
        ProductStatus = productStatus;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
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

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
