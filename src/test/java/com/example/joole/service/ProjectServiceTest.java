package com.example.joole.service;

import com.example.joole.model.Project;
import com.example.joole.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ProjectServiceTest {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;
    @Test
    void createProject() {
        Project project=new Project();
        project.setProjectId(1L);
        projectService.createProject(project);
        System.out.println(project);
        Assertions.assertNotNull(projectService);
    }

    @Test
    void findProject() {
        System.out.println(projectService.findProject());
        Assertions.assertNotNull(projectService.findProject());
    }

    @Test
    void findProjectById() {
        Project project=new Project();
        User user=new User();
        userService.createUser(user);
        project.setUser(user);
        projectService.createProject(project);
        System.out.println(projectService.toString());
        Assertions.assertNotNull(projectService.findProjectById(project.getProjectId()));
    }

    @Test
    void deleteProject() {
        Project project=new Project();
        User user=new User();
        userService.createUser(user);
        project.setUser(user);
        projectService.createProject(project);
        projectService.deleteProject(project.getProjectId());
        Assertions.assertNull(projectService.findProjectById(project.getProjectId()));
    }
}