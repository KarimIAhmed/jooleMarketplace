package com.example.joole.controller;

import com.example.joole.model.Product;
import com.example.joole.repository.ProductRepository;
import com.example.joole.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    //get all products
    @GetMapping("/product")
    public List<Product> getAllProducts(){
        return productService.findProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

}
