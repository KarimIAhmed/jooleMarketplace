package com.example.joole.repository;

import com.example.joole.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    /*
    @BeforeAll
    static void create() {
        Product product = new Product();
        product.setProductBrand("testProductBrand");
        product.setCertification("testCertification");
    }*/


    @Test
    void findByProductBrand() {
        List<Product> productList = productRepository.findByProductBrand("testProductBrand").orElse(null);
        System.out.println(productList);
        Assertions.assertNotNull(productList);
    }

    @Test
    void findByCertification() {
        List<Product> productList = productRepository.findByCertification("testCertification").orElse(null);
        System.out.println(productList);
        Assertions.assertNotNull(productList);
    }

}