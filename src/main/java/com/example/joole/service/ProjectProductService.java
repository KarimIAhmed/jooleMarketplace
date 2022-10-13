package com.example.joole.service;

import com.example.joole.model.ProjectProduct;

import java.util.List;

public interface ProjectProductService {
    ProjectProduct createProjectProduct(ProjectProduct projectProduct);
    List<ProjectProduct> findProjectProduct();
    ProjectProduct findProjectProductById(long Id);
    String deleteProjectProduct(long id);
}
