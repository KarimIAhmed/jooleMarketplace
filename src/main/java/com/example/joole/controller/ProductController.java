package com.example.joole.controller;

import com.example.joole.model.Product;
import com.example.joole.model.ProductType;
import com.example.joole.service.ProductService;
import com.example.joole.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
//@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductTypeService productTypeService;



    @PostMapping("/createproduct")
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        return ResponseEntity.ok(productService.createProduct(product));
    }

    @PostMapping("/createproducttype")
    public ResponseEntity<?> createProductType(@RequestBody ProductType productType){
        return ResponseEntity.ok(productTypeService.createProductType(productType));
    }

    @RequestMapping(path = "deleteproduct/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product " + id + " has been deleted!");
    }

    @RequestMapping(path = "deleteproducttype/{id}")
    public ResponseEntity<?> deleteProductType(@PathVariable long id) {
        productTypeService.deleteProductType(id);
        return ResponseEntity.ok("Product Type " + id + " has been deleted!");
    }

}
