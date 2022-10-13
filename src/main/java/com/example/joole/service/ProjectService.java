package com.example.joole.service;

import com.example.joole.model.Project;

import java.util.List;

public interface ProjectService {
    Project createProject(Project project);
    List<Project> findProject();
    Project findProjectById(long Id);
    String deleteProject(long id);
}
