package com.example.joole.service.impl;

import com.example.joole.model.Description;
import com.example.joole.model.Product;
import com.example.joole.service.DescriptionService;
import com.example.joole.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DescriptionServiceImplTest {

    @Autowired
    DescriptionService descriptionService;

    @Autowired
    ProductService productService;

    @Test
    void saveDescription() {
        Description description = new Description();
        description.setManufacturer("Nike Manufacturer");
        description.setModel("Nike Model");
        description.setSeries("Nike Series");
        description.setProduct(productService.findProductById(1L));

        descriptionService.saveDescription(description);
        System.out.println("Successful save the description: " + description);
    }

    @Test
    void findDescriptionByProductId() {
        System.out.println("The description of product 1 is: " + descriptionService.findDescriptionByProductId(1L));
    }

    @Test
    void deleteProduct() {
    }
}