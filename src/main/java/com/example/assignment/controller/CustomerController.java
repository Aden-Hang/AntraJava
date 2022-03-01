package com.example.assignment.controller;

import com.example.assignment.exception.UserNotFoundException;
import com.example.assignment.pojo.Product;
import com.example.assignment.repository.ProductRepository;
import com.example.assignment.response.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping(value="/product/{pid}")
    public ResponseEntity<Product> getProductById(@PathVariable("pid") String id){
        return new ResponseEntity<Product>(productRepository.getProductById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/product")
    public ResponseEntity<Product> createNewProduct(@RequestBody @Validated Product product){
        Product savedProduct = productRepository.addProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/product")
    public ResponseEntity<Product> updateOldProduct(@RequestBody Product product){
        Product savedProduct = productRepository.updateProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value="/product")
    public ResponseEntity<Product> delete(@RequestBody Product product){
        Product savedProduct = productRepository.deleteProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.ACCEPTED);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity exceptionHandler(Exception e){
        return new ResponseEntity<>(new ErrorResponse("The product cannot be found", "404"), HttpStatus.NOT_FOUND);
    }
}
