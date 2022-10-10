package com.example.joole.service;

import com.example.joole.model.Project;
import com.example.joole.model.User;
import com.example.joole.repository.ProjectRepository;
import com.example.joole.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project findProjectById(Long id){
        return projectRepository.findById(id).orElse(null);
    }

    public void createProject(User user){
        Project project = new Project();
        project.setUser(user);

        projectRepository.save(project);
    }

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
