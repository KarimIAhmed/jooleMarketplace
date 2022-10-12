package com.example.joole.service;

import com.example.joole.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    List<Product> findProductsByProductBrand(String brand);

    Product saveProduct(Product product);

    List<Product> getProducts();

    String deleteProduct(long id);

    Product findProductById(Long id);

}
