package com.reposteria.mana.domain.entities;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Category category;
    private Integer stockQuantity;

    public Product(Long id, String name, String description, Double price, Category category, Integer stockQuantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.stockQuantity = stockQuantity;
    }
}
