package com.example.joole.service.Impl;

import com.example.joole.model.Project;
import com.example.joole.model.ProjectProduct;
import com.example.joole.repository.ProjectProductRepository;
import com.example.joole.repository.ProjectRepository;
import com.example.joole.service.ProjectProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectProductServiceImpl implements ProjectProductService {
    @Autowired
    private ProjectProductRepository projectProductRepository;

    public ProjectProduct createProjectProduct(ProjectProduct projectProduct){
        return projectProductRepository.save(projectProduct);
    }

    public List<ProjectProduct> findProjectProduct(){
        return projectProductRepository.findAll();
    }

    public ProjectProduct findProjectProductById(long Id){
        return projectProductRepository.findById(Id).orElse(null);
    }

    public String deleteProjectProduct(long id){
        projectProductRepository.deleteById(id);
        return "Project Product " + id + " has been removed";
    }
}
