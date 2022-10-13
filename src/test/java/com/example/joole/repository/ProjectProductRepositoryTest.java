package com.example.joole.repository;

import com.example.joole.model.Description;
import com.example.joole.model.Product;
import com.example.joole.model.Project;
import com.example.joole.model.ProjectProduct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectProductRepositoryTest {

    @Autowired
    private ProjectProductRepository projectProductRepository;

    @Test
    void findByProject() {
        Project project=new Project();
        project.setProjectId(10L);
        List<ProjectProduct> projectProductList = projectProductRepository.findByProject(project).orElse(null);
        System.out.println(projectProductList);
        Assertions.assertNotNull(projectProductList);
    }

    @Test
    void findByProduct() {
        Product product=new Product();
        product.setId(10L);
        List<ProjectProduct> projectProductList = projectProductRepository.findByProduct(product).orElse(null);
        System.out.println(projectProductList);
        Assertions.assertNotNull(projectProductList);
    }
}