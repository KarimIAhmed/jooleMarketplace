package com.example.joole.service.impl;

import com.example.joole.model.ProductType;
import com.example.joole.service.ProductTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductTypeServiceImplTest {

    @Autowired
    ProductTypeServiceImpl productTypeService;

    @Autowired
    ProductServiceImpl productService;

    @Test
    void saveProductType() {
        ProductType productType = new ProductType();
        productType.setType("Sneaker");
        productType.setAccessories("shoelace");
        productType.setModel_year("2020");
        productType.setMountain_location("LA");

        productTypeService.saveProductType(productType);
    }

    @Test
    void getProductTypes() {
        System.out.println(productTypeService.getProductTypes());
    }

    @Test
    void deleteProductType() {
        productTypeService.deleteProductType(2L);
    }
}