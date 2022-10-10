package com.example.joole.service;

import com.example.joole.model.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);
    List<Product> findProducts();
    Product findProductById(Long Id);
    String deleteProduct(long id);

}
