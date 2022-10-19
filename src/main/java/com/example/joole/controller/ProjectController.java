package com.example.joole.controller;

import com.example.joole.model.Product;
import com.example.joole.model.Project;
import com.example.joole.service.ProductService;
import com.example.joole.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProductService productService;


    @PostMapping("/createproject")
    public ResponseEntity<?> createProject(@RequestBody Project project) {
        return ResponseEntity.ok(projectService.createProject(project));
    }

    @RequestMapping(path = "deleteproject/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable long id) {
        projectService.deleteProject(id);
        return ResponseEntity.ok("Project " + id + " has been deleted!");
    }

    //addProductToProject(Project, Product)
    @RequestMapping("/addproducttoproject")
    public ResponseEntity<?> addProductToProject(Project project,Product product){
        return null;
    }
    //deleteProductFromProject
    //updateProductFromProject
    //getProductListFromProject
}
