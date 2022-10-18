package com.example.joole.controller;

import com.example.joole.model.Product;
import com.example.joole.model.ProductType;
import com.example.joole.service.ProductService;
import com.example.joole.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.findProducts();
    }
    /*public ResponseEntity<?> getAllProducts(){
        return productService.findProducts();
    }*/

    @GetMapping("/producttypes")
    public List<ProductType> getProductTypes(){
        return productTypeService.findProductTypes();
    }


    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

}
