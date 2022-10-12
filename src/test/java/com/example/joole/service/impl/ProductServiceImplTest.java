package com.example.joole.service.impl;

import com.example.joole.model.*;
import com.example.joole.service.ProjectProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    ProductServiceImpl productService;

    @Autowired
    ProjectProductService projectProductService;

    @Autowired
    ProjectServiceImpl projectService;

    @Autowired
    com.example.joole.service.implementation.DescriptionServiceImpl descriptionService;

    @Autowired
    ProductTypeServiceImpl productTypeService;

    @Autowired
    TechnicalDetailServiceImpl technicalDetailService;

    @Test
    void saveProduct() {
        //Create product
        Product product = new Product();
        product.setProductBrand("Nike");
        product.setCertification("Nike Certification");

        //Create Description
        Description description = new Description();
        description.setSeries("Nike Series");
        description.setModel("Nike Model");
        description.setManufacturer("Nike Manufacturer");
        descriptionService.saveDescription(description);

        product.setDescription(description);

        //Create TechnicalDetail
        TechnicalDetails technicalDetails = new TechnicalDetails();
        technicalDetails.setPower(110);
        technicalDetails.setFanSpeed(100);
        technicalDetails.setAirflow(156);
        technicalDetails.setOperatingVoltage(358);
        technicalDetailService.saveTechnicalDetails(technicalDetails);

        product.setTechnicalDetails(technicalDetails);

        //Create ProductType
        ProductType productType = new ProductType();
        productType.setType("Sneaker");
        productType.setMountain_location("Mountain_Location");
        productType.setAccessories("Accessories");
        productType.setModel_year("2022");
        productType.setApplication("Application");
        productTypeService.saveProductType(productType);

        product.setProductType(productType);

        //Create projectProduct
        ProjectProduct projectProduct = new ProjectProduct();
        projectProduct.setProject(projectService.findProjectById(1L));
        projectProduct.setProduct(product);

        //Create projectProductSet
        Set<ProjectProduct> projectProductSet = new HashSet<>();
        projectProductSet.add(projectProduct);

        //set projectProductSet to product
        product.setProjectProductSet(projectProductSet);

        //save product
        productService.saveProduct(product);

        //update description
//        Description description1 = descriptionService.findDescriptionByProductId(21L);
//        description1.setProduct(productService.findProductById(21L));

        System.out.println("Successful Save the product: " + product);
    }

    @Test
    void getProducts() {
        System.out.println(productService.getProducts());
    }

    @Test
    void deleteProduct() {
        productService.deleteProduct(1L);
    }

    @Test
    void findProductById() {
        System.out.println("Find the product by id 1: " + productService.findProductById(1L));
    }

    @Test
    void findProductsByProductBrand() {
        System.out.println(productService.findProductsByProductBrand("Nike"));
    }
}