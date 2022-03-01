package com.example.assignment.pojo;

import lombok.Data;

@Data
public class Product {
    private String id;
    private String name;
    private Integer price;

    public Product(String id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
