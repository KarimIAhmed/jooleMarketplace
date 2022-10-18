package com.example.joole.controller;

import com.example.joole.model.Project;
import com.example.joole.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects")
    public List<Project> getProjects(){
        return projectService.findProject();
    }

    @PostMapping("/createProject")
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }

    @RequestMapping(path = "deleteproject/{id}")
    public String deleteProject(@PathVariable long id) {
        projectService.deleteProject(id);
        return "Project " + id + " has been deleted!";
    }
}
