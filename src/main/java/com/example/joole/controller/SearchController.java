package com.example.joole.controller;

import com.example.joole.service.ProductService;
import com.example.joole.service.ProductTypeService;
import com.example.joole.service.ProjectService;
import com.example.joole.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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


}
