package com.example.assignment.repository;

import com.example.assignment.exception.UserNotFoundException;
import com.example.assignment.pojo.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    List<Product> products = new ArrayList<>();
    public ProductRepository() {
        products.add(new Product("p-001","coke",1));
        products.add(new Product("p-002","bbbb",2));
        products.add(new Product("p-003","cccc",3));
        products.add(new Product("p-004","dddd",4));
        products.add(new Product("p-005","eeee",5));
        products.add(new Product("p-006","ffff",6));
        products.add(new Product("p-007","gggg",7));
        products.add(new Product("p-008","hhhh",8));
        products.add(new Product("p-009","iiii",9));
    }

    public Product getProductById(String id){
        return this.products.stream().filter(c -> c.getId().equals(id)).findFirst().orElseThrow(UserNotFoundException::new);
    }

    public Product addProduct(Product product) {
        this.products.add(product);
        return product;
    }

    public Product updateProduct(Product product) {
        boolean found = false;
        for(Product p : products){
            if(p.getId().equals(product.getId())){
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                found = true;
                break;
            }
        }

        if(!found){
            throw new UserNotFoundException();
        }

        return product;
    }

    public Product deleteProduct(Product product) {
        boolean found = false;
        for(Product p : products){
            if(p.getId().equals(product.getId())){
                products.remove(p);
                found = true;
                break;
            }
        }

        if(!found){
            throw new UserNotFoundException();
        }

        return product;
    }
}
