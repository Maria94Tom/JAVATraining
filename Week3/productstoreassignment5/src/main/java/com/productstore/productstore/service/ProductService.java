package com.productstore.productstore.service;

import com.productstore.productstore.entities.Product;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface ProductService {
    public List<Product> getAllProductSorted(String field);
    public Page<Product> getAllProductPage(int offset, int pageSize);
    public Page<Product> getAllProductPageSorted(String field,int offset, int pageSize);







}
