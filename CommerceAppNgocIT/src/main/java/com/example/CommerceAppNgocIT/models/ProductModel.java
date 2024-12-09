package com.example.CommerceAppNgocIT.models;

import jakarta.persistence.*;

@Entity
@Table(name="product")
public class ProductModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
        private long id;
        private String name;
        private String category;
        private double rating;
        private int reviewCount;
        private double currentPrice;
        private double originalPrice;
        private String promotionLabel;
        private String imagePath;

        // Constructors
        public ProductModel() {
        }

        public ProductModel( String name, String category, double rating, int reviewCount,
                       double currentPrice, double originalPrice, String promotionLabel, String imagePath) {

            this.name = name;
            this.category = category;
            this.rating = rating;
            this.reviewCount = reviewCount;
            this.currentPrice = currentPrice;
            this.originalPrice = originalPrice;
            this.promotionLabel = promotionLabel;
            this.imagePath = imagePath;
        }

        // Getters and Setters


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public int getReviewCount() {
            return reviewCount;
        }

        public void setReviewCount(int reviewCount) {
            this.reviewCount = reviewCount;
        }

        public double getCurrentPrice() {
            return currentPrice;
        }

        public void setCurrentPrice(double currentPrice) {
            this.currentPrice = currentPrice;
        }

        public double getOriginalPrice() {
            return originalPrice;
        }

        public void setOriginalPrice(double originalPrice) {
            this.originalPrice = originalPrice;
        }

        public String getPromotionLabel() {
            return promotionLabel;
        }

        public void setPromotionLabel(String promotionLabel) {
            this.promotionLabel = promotionLabel;
        }

        public String getImagePath() {
            return imagePath;
        }

        public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
        }
    }


