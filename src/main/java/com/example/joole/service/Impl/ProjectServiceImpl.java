package com.example.joole.service.Impl;

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

    public Project createProject(Project project){
        return projectRepository.save(project);
    }

    public List<Project> findProject(){
        return projectRepository.findAll();
    }

    public Project findProjectById(long Id){
        return projectRepository.findById(Id).orElse(null);
    }

    public String deleteProject(long id){
        projectRepository.deleteById(id);
        return "Project " + id + " has been removed";
    }
}
