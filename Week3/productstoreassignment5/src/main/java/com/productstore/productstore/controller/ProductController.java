package com.productstore.productstore.controller;

import com.productstore.productstore.entities.Product;
import com.productstore.productstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
//http://localhost:8081/productstore/productsorted?field=price
    //http://localhost:8081/productstore/productpage?offset=2&pageSize=10
   // http://localhost:8081/productstore/productpagesorted?offset=2&pageSize=10&field=name

    @GetMapping(path = "productsorted")
    public List<Product> getAllProductSorted(@RequestParam(name="field")  String field) {
        return productService.getAllProductSorted(field);
    }
    @GetMapping(path = "productpage")
    public Page<Product> getAllProductPage(@RequestParam(name="offset") int offset, @RequestParam(name="pageSize") int pageSize) {
        return productService.getAllProductPage(offset, pageSize);
    }
    @GetMapping(path = "productpagesorted")
    public Page<Product> getAllProductPageSorted(@RequestParam(name="offset")int offset,@RequestParam(name="pageSize") int pageSize,@RequestParam(name="field")String field) {
        return productService.getAllProductPageSorted(field, offset, pageSize);
    }



}
