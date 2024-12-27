package com.example.CommerceAppNgocIT.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="category")
public class Category {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "categoryName")
    private String categoryName;
    @Column(name = "price")
    private double price;
    @Column(name = "image")
    private String image;
    @Column(name = "description")
    private String description;
    // Quan hệ ManyToOne từ Category đến ProductModel
    @ManyToOne
    @JoinColumn(name ="productId",referencedColumnName = "productId")
    private ProductModel productModel;


    public Category() {

    }

    public Category(int id, String categoryName, double price, String image, String description, ProductModel productModel) {
        this.id = id;
        this.categoryName = categoryName;
        this.price = price;
        this.image = image;
        this.description = description;
        this.productModel = productModel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductModel getProductModel() {
        return productModel;
    }

    public void setProductModel(ProductModel productModel) {
        this.productModel = productModel;
    }
}
