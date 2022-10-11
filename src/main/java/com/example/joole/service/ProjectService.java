package com.example.joole.service;

import com.example.joole.model.Project;
import com.example.joole.model.ProjectProduct;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<Project> findProjectsByUserName(String name);

    Project saveProject(Project project);

    Project findProjectById(Long id);

    String deleteProject(long id);

    List<Project> getProject();
}
