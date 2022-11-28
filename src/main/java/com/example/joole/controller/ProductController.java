package com.example.joole.controller;

import com.example.joole.model.Product;
import com.example.joole.model.ProductType;
import com.example.joole.model.User;
import com.example.joole.service.ProductService;
import com.example.joole.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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



    @PostMapping("/createProduct")
    public ResponseEntity<?> createProduct(@RequestParam(name = "productBrand") String productBrand,
                                           @RequestParam(name = "certification") String certification) {
        return ResponseEntity.ok(productService.createProduct(new Product(productBrand,certification,null,null,null,null)));
    }

    @PostMapping("/createProductType")
    public ResponseEntity<?> createProductType(@RequestParam(name = "application") String application,
                                               @RequestParam(name = "type") String type,
                                               @RequestParam(name = "mountingLocation") String mountingLocation,
                                               @RequestParam(name = "accessories") String accessories,
                                               @RequestParam(name = "modelYear") int modelYear) {
        return ResponseEntity.ok(productTypeService.createProductType(new ProductType(application,type,mountingLocation,accessories,modelYear,null)));
    }

    @PutMapping("/updateProductBrand")
    public ResponseEntity<?> updateProductBrandByProductId(@RequestParam(name = "id") Long id, @RequestParam(name = "productBrand") String productBrand){
        Product product =productService.findProductById(id);
        if (product == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product does not exist!");
        product.setProductBrand(productBrand);
        return ResponseEntity.ok("Product brand has been updated!");
    }

    @PutMapping("/updateCertification")
    public ResponseEntity<?> updateCertificationByProductTypeId(@RequestParam(name = "id") Long id, @RequestParam(name = "certification") String certification){
        Product product =productService.findProductById(id);
        if (product == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product does not exist!");
        product.setCertification(certification);
        return ResponseEntity.ok("Product certification has been updated!");
    }
    @PutMapping("/updateApplication")
    public ResponseEntity<?> updateApplicationByProductTypeId(@RequestParam(name = "id") Long id, @RequestParam(name = "application") String application){
        ProductType productType =productTypeService.findProductTypeById(id);
        if (productType == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product type does not exist!");
        productType.setApplication(application);
        return ResponseEntity.ok("Product application has been updated!");
    }

    @PutMapping("/updateAccessories")
    public ResponseEntity<?> updateAccessoriesByProductTypeId(@RequestParam(name = "id") Long id, @RequestParam(name = "accessories") String accessories){
        ProductType productType =productTypeService.findProductTypeById(id);
        if (productType == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product type does not exist!");
        productType.setAccessories(accessories);
        return ResponseEntity.ok("Product accessory has been updated!");
    }

    @PutMapping("/updateModelYear")
    public ResponseEntity<?> updateModelYearByProductTypeId(@RequestParam(name = "id") Long id, @RequestParam(name = "modelYear") int modelYear){
        ProductType productType =productTypeService.findProductTypeById(id);
        if (productType == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product type does not exist!");
        productType.setModelYear(modelYear);
        return ResponseEntity.ok("Product model year has been updated!");
    }
    @PutMapping("/updateMountingLocation")
    public ResponseEntity<?> updateMountingLocationByProductTypeId(@RequestParam(name = "id") Long id, @RequestParam(name = "mountingLocation") String mountingLocation){
        ProductType productType =productTypeService.findProductTypeById(id);
        if (productType == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product type does not exist!");
        productType.setMountingLocation(mountingLocation);
        return ResponseEntity.ok("Product type has been updated!");
    }

    @PutMapping("/updateType")
    public ResponseEntity<?> updateTypeByProductTypeId(@RequestParam(name = "id") Long id, @RequestParam(name = "type") String type){
        ProductType productType =productTypeService.findProductTypeById(id);
        if (productType == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product type does not exist!");
        productType.setType(type);
        return ResponseEntity.ok("Product type has been updated!");
    }

    @RequestMapping(path = "/deleteProduct/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product " + id + " has been deleted!");
    }

    @RequestMapping(path = "/deleteProductType/{id}")
    public ResponseEntity<?> deleteProductType(@PathVariable long id) {
        productTypeService.deleteProductType(id);
        return ResponseEntity.ok("Product Type " + id + " has been deleted!");
    }

}
