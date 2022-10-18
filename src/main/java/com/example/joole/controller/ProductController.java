package com.example.joole.controller;

import com.example.joole.model.Product;
import com.example.joole.model.ProductType;
import com.example.joole.service.ProductService;
import com.example.joole.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductTypeService productTypeService;

    @GetMapping("/products")
//    public List<Product> getAllProducts(){
//        return productService.findProducts();
//    }
    public ResponseEntity<?> getAllProducts(){
        return ResponseEntity.ok(productService.findProducts());
    }

    @GetMapping("/producttypes")
    public List<ProductType> getProductTypes(){
        return productTypeService.findProductTypes();
    }


    @PostMapping("/createproduct")
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @PostMapping("/createproducttype")
    public ProductType createProductType(@RequestBody ProductType productType){
        return productTypeService.createProductType(productType);
    }

    @RequestMapping(path = "deleteproduct/{id}")
    public String deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
        return "Product " + id + " has been deleted!";
    }

    @RequestMapping(path = "deleteproducttype/{id}")
    public String deleteProductType(@PathVariable long id) {
        productTypeService.deleteProductType(id);
        return "Product Type " + id + " has been deleted!";
    }
}
