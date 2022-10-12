package com.example.joole.service;

import com.example.joole.model.Product;
import com.example.joole.model.Project;
import com.example.joole.model.ProjectProduct;

import java.util.List;

public interface ProjectProductService {
    List<ProjectProduct> findAllByProduct(Product product);

    List<ProjectProduct> findAllByProject(Project project);

    ProjectProduct findById(Long id);

    ProjectProduct saveProjectProduct(ProjectProduct projectProduct);
}
