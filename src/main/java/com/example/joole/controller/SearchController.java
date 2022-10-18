package com.example.joole.controller;

import com.example.joole.model.Product;
import com.example.joole.model.ProductType;
import com.example.joole.model.Project;
import com.example.joole.model.User;
import com.example.joole.service.ProductService;
import com.example.joole.service.ProductTypeService;
import com.example.joole.service.ProjectService;
import com.example.joole.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id) {
        Product product = productService.findProductById(id);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/producttypes/{id}")
    public ResponseEntity<ProductType> getProductTypeById(@PathVariable long id) {
        ProductType productType = productTypeService.findProductTypeById(id);
        return ResponseEntity.ok(productType);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getEmployeeById(@PathVariable long id) {
        User employee = userService.findUserById(id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable long id) {
        Project project = projectService.findProjectById(id);
        return ResponseEntity.ok(project);
    }
}
