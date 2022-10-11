package com.example.joole.service.impl;

import com.example.joole.model.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProjectServiceImplTest {

    @Autowired
    ProjectServiceImpl projectService;

    @Autowired
    UserServiceImpl userService;

    @Test
    void findProjectById() {
        System.out.println(projectService.findProjectById(1L));
    }

    @Test
    void saveProject() {
        Project project = new Project();
        project.setUser(userService.findOneByID(1L));

        projectService.saveProject(project);
    }

    @Test
    void getProject() {
        System.out.println(projectService.getProject());
    }

    @Test
    void deleteProject() {
        projectService.deleteProject(4L);
        System.out.println("Succussful delete project 4.");
        System.out.println("The projects after delete is: " + projectService.getProject());
    }

    @Test
    void findProjectsByUserName() {
        //Find project by username
        System.out.println("Find all projects of user Tengyang Zhang: " + projectService.findProjectsByUserName("Tengyang Zhang"));
    }
}