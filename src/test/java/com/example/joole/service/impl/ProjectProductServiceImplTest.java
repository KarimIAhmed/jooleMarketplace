package com.example.joole.service.impl;

import com.example.joole.model.ProjectProduct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectProductServiceImplTest {

    @Autowired
    ProjectServiceImpl projectService;

    @Autowired
    ProductServiceImpl productService;

    @Autowired
    ProjectProductServiceImpl projectProductService;

    @Test
    void saveProjectProduct() {
        ProjectProduct projectProduct = new ProjectProduct();
        projectProduct.setProduct(productService.findProductById(1L));
        projectProduct.setProject(projectService.findProjectById(1L));

        projectProductService.saveProjectProduct(projectProduct);

        System.out.println("Successful save projectProduct: " + projectProduct);
    }

    @Test
    void findAllByProduct() {
        System.out.println("Find all by product: " + projectProductService.findAllByProduct(productService.findProductById(1L)));
    }

    @Test
    void findAllByProject() {
        System.out.println("Find all by project: " + projectProductService.findAllByProject(projectService.findProjectById(1L)));
    }

    @Test
    void findById() {
        System.out.println("Find projectProduct by id 1: " + projectProductService.findById(1L));
    }


}