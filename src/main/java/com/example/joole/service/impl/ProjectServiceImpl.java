package com.example.joole.service.impl;

import com.example.joole.model.Project;
import com.example.joole.model.User;
import com.example.joole.repository.ProjectRepository;
import com.example.joole.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserServiceImpl userService;

    public Project findProjectById(Long id){
        return projectRepository.findById(id).orElse(null);
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

    @Override
    public List<Project> findProjectsByUserName(String name) {
        User user = userService.findUserByUserName(name);

        return projectRepository.findAllByUser(user);
    }
}
