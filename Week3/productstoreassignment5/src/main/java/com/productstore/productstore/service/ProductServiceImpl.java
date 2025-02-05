package com.productstore.productstore.service;

import com.productstore.productstore.entities.Product;
import com.productstore.productstore.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepo productRepo;
@Autowired
    public ProductServiceImpl(ProductRepo productRepo){
        this.productRepo = productRepo;
    }
    @Override
    public List<Product> getAllProductSorted(String field) {
        return productRepo.findAll(Sort.by(Sort.Direction.DESC, field));

    }

    @Override
    public Page<Product> getAllProductPage(int offset, int pageSize) {
        return productRepo.findAll(PageRequest.of(offset, pageSize));

    }

    @Override
    public Page<Product> getAllProductPageSorted(String field, int offset, int pageSize) {
        return productRepo.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));

    }
}
