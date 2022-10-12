package com.example.joole.service.impl;

import com.example.joole.model.Product;
import com.example.joole.model.Project;
import com.example.joole.model.ProjectProduct;
import com.example.joole.repository.ProjectProductRepository;
import com.example.joole.service.ProjectProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectProductServiceImpl implements ProjectProductService {
    @Autowired
    private ProjectProductRepository projectProductRepository;

    @Override
    public List<ProjectProduct> findAllByProduct(Product product) {
        return projectProductRepository.findAllByProduct(product);
    }

    @Override
    public List<ProjectProduct> findAllByProject(Project project) {
        return projectProductRepository.findAllByProject(project);
    }

    @Override
    public ProjectProduct findById(Long id) {
        return projectProductRepository.findById(id).orElse(null);
    }

    @Override
    public ProjectProduct saveProjectProduct(ProjectProduct projectProduct) {
        return projectProductRepository.save(projectProduct);
    }
}
