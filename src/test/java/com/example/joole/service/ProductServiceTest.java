package com.example.joole.service;

import com.example.joole.model.Description;
import com.example.joole.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Test
    void createProduct() {
        Product product=new Product();
        product.setProductBrand("test");
        productService.createProduct(product);
        System.out.println(product);
        Assertions.assertNotNull(productService);
    }

    @Test
    void findProducts() {
        System.out.println(productService.findProducts());
        Assertions.assertNotNull(productService.findProducts());
    }

    @Test
    void findProductById() {
        Product product=new Product();
        product.setId(1);
        productService.createProduct(product);
        Assertions.assertNotNull(productService.findProductById(1L));
    }

    @Test
    void deleteProduct() {
        Product product=new Product();
        product.setId(4);
        productService.createProduct(product);
        productService.deleteProduct(product.getId());
        Assertions.assertNull(productService.findProductById(99999L));
    }
}