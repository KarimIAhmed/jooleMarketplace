package com.example.joole.service;

import com.example.joole.model.Product;
import com.example.joole.model.ProjectProduct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ProjectProductServiceTest {

    @Autowired
    private ProjectProductService projectProductService;

    @Test
    void createProjectProduct() {
        ProjectProduct projectProduct=new ProjectProduct();
        projectProduct.setProjectProductId(1L);
        projectProductService.createProjectProduct(projectProduct);
        System.out.println(projectProduct);
        Assertions.assertNotNull(projectProductService);
    }

    @Test
    void findProjectProduct() {
        System.out.println(projectProductService.findProjectProduct());
        Assertions.assertNotNull(projectProductService.findProjectProduct());
    }

    @Test
    void findProjectProductById() {
        ProjectProduct projectProduct=new ProjectProduct();
        projectProduct.setProjectProductId(1L);
        projectProductService.createProjectProduct(projectProduct);
        Assertions.assertNotNull(projectProductService.findProjectProductById(1L));
    }

    @Test
    void deleteProjectProduct() {
        ProjectProduct projectProduct=new ProjectProduct();
        projectProduct.setProjectProductId(3L);
        projectProductService.createProjectProduct(projectProduct);
        projectProductService.deleteProjectProduct(projectProduct.getProjectProductId());
        Assertions.assertNull(projectProductService.findProjectProductById(3));
    }
}