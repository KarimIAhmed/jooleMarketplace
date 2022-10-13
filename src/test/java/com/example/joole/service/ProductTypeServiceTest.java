package com.example.joole.service;

import com.example.joole.model.Product;
import com.example.joole.model.ProductType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductTypeServiceTest {
    @Autowired
    private ProductTypeService productTypeService;

    @Test
    void createProductType() {
        ProductType productType=new ProductType();
        productType.setType("test");
        productTypeService.createProductType(productType);
        System.out.println(productType);
        Assertions.assertNotNull(productTypeService);
    }

    @Test
    void findProductTypes() {
        System.out.println(productTypeService.findProductTypes());
        Assertions.assertNotNull(productTypeService.findProductTypes());
    }

    @Test
    void findProductTypeById() {
        ProductType productType=new ProductType();
        productType.setId(1);
        productTypeService.createProductType(productType);
        Assertions.assertNotNull(productTypeService.findProductTypeById(1L));
    }

    @Test
    void deleteProductType() {
        ProductType productType=new ProductType();
        productType.setId(1);
        productTypeService.createProductType(productType);
        productTypeService.deleteProductType(productType.getId());
        Assertions.assertNull(productTypeService.findProductTypeById(1L));
    }
}