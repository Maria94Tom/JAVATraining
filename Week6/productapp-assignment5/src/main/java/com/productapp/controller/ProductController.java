package com.productapp.controller;

import com.productapp.repo.Product;
import com.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

@GetMapping("/products")
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAll());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getById(String id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getById(id));
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> update(String id, Product book) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.update(id, book));
    }

@PostMapping("/products")
    public ResponseEntity<Product> save(Product book) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.save(book));
    }

@DeleteMapping("/products/{id}")
    public ResponseEntity<Void> delete(String id) {
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
