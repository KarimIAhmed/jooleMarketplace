package com.example.joole.service.impl;

import com.example.joole.model.Product;
import com.example.joole.model.ProjectProduct;
import com.example.joole.service.ProjectProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    ProductServiceImpl productService;

    @Autowired
    ProjectProductService projectProductService;

    @Autowired
    ProjectServiceImpl projectService;

    @Autowired
    com.example.joole.service.implementation.DescriptionServiceImpl descriptionService;

    @Test
    void saveProduct() {
        //Create product
        Product product = new Product();
        product.setProductBrand("Nike");
        product.setCertification("Nike Certification");
        product.setDescription(descriptionService.findById(1L));

        //Create projectProduct
        ProjectProduct projectProduct = new ProjectProduct();
        projectProduct.setProject(projectService.findProjectById(1L));
        projectProduct.setProduct(product);

        //Create projectProductSet
        Set<ProjectProduct> projectProductSet = new HashSet<>();
        projectProductSet.add(projectProduct);

        //set projectProductSet to product
        product.setProjectProductSet(projectProductSet);

        //save product
        productService.saveProduct(product);

        System.out.println("Successful Save the product: " + product);
    }

    @Test
    void getProducts() {
        System.out.println(productService.getProducts());
    }

    @Test
    void deleteProduct() {
        productService.deleteProduct(1L);
    }

    @Test
    void findProductById() {
        System.out.println("Find the product by id 1: " + productService.findProductById(1L));
    }

    @Test
    void findProductsByProductBrand() {
        System.out.println(productService.findProductsByProductBrand("Nike"));
    }
}