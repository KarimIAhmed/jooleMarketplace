package com.example.joole.service;

import com.example.joole.model.Project;
import com.example.joole.model.User;
import com.example.joole.repository.ProjectRepository;
import com.example.joole.repository.UserRepository;

import java.util.List;

public class ProjectService {
    private ProjectRepository projectRepository;

    public Project saveProject(Project project){
        return projectRepository.save(project);
    }

    public List<Project> getProject(){
        return projectRepository.findAll();
    }

    public String deleteProject(long id){
        projectRepository.deleteById(id);
        return "product " + id + " has been removed";
    }
}
