package com.example.joole.controller;

import com.example.joole.model.Product;
import com.example.joole.model.Project;
import com.example.joole.model.ProjectProduct;
import com.example.joole.service.ProductService;
import com.example.joole.service.ProjectProductService;
import com.example.joole.service.ProjectService;
import com.example.joole.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProjectProductService projectProductService;


    @PostMapping("/createProject")
    public ResponseEntity<?> createProject(@RequestParam(name = "projectId") long projectId) {
        return ResponseEntity.ok(projectService.createProject(new Project(projectId,null,null)));
    }

    @RequestMapping(path = "deleteProject/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable long id) {
        projectService.deleteProject(id);
        return ResponseEntity.ok("Project " + id + " has been deleted!");
    }

    @PutMapping("/addProductToProjectById")
    public ResponseEntity<?> addProductToProjectById(@RequestParam(name = "projectid") Long projectId,
                                                     @RequestParam(name = "productId") Long productId) {
        Project project=projectService.findProjectById(projectId);
        Product product=productService.findProductById(productId);
        ProjectProduct projectProduct=new ProjectProduct(5L,project,product);
        projectProductService.createProjectProduct(projectProduct);
        return ResponseEntity.ok("produc was added to project with id" + projectId);
    }

    @DeleteMapping(path = "deleteProductFromProject")
    public ResponseEntity<?> deleteProductFromProject(@RequestParam(name = "projectId") long projectId,
                                                      @RequestParam(name = "productId") long productId) {
        ProjectProduct p=projectProductService.findProjectProductByProductId(productId);
        projectProductService.deleteProjectProduct(p.getId());
        return ResponseEntity.ok("product has been removed from project with ID " + projectId);
    }
    @PutMapping(path="/updateProjectUser")
    public ResponseEntity<?> updateProjectUser(@RequestParam(name = "projectId") long projectId,
                                              @RequestParam(name = "userId") long userId){
        Project project=projectService.findProjectById(projectId);
        project.setUser(userService.findUserById(userId));
        return ResponseEntity.ok("Project user has been updated!");
    }
}
