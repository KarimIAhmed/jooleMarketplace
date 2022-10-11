package com.example.joole.service;

import com.example.joole.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findProductsByProductBrand(String brand);

    Product saveProduct(Product product);

    List<Product> getProducts();

    String deleteProduct(long id);
}
