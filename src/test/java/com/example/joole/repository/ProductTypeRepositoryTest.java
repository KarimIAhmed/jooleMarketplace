package com.example.joole.repository;

import com.example.joole.model.ProductType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductTypeRepositoryTest {

    @Autowired
    private ProductTypeRepository productTypeRepository;

    /*
    @BeforeAll
    static void create() {
        ProductType productType= new ProductType();
        productType.setApplication("testApplication");
        productType.setType("testType");
        productType.setMountingLocation("testMountingLocation");
        productType.setAccessories("testAccessory");
        productType.setmodelYear(2000);
    }*/

    @Test
    void findByApplication() {
        List<ProductType> productTypeList = productTypeRepository.findByApplication("testApplication").orElse(null);
        System.out.println(productTypeList);
        Assertions.assertNotNull(productTypeList);
    }

    @Test
    void findByType() {
        List<ProductType> productTypeList = productTypeRepository.findByType("testType").orElse(null);
        System.out.println(productTypeList);
        Assertions.assertNotNull(productTypeList);
    }

    @Test
    void findByMountingLocation() {
        List<ProductType> productTypeList = productTypeRepository.findByMountingLocation("testMountingLocation").orElse(null);
        System.out.println(productTypeList);
        Assertions.assertNotNull(productTypeList);
    }

    @Test
    void findByAccessories() {
        List<ProductType> productTypeList = productTypeRepository.findByAccessories("testAccessory").orElse(null);
        System.out.println(productTypeList);
        Assertions.assertNotNull(productTypeList);
    }

    @Test
    void findByModelYear() {
        List<ProductType> productTypeList = productTypeRepository.findByModelYear(2000).orElse(null);
        System.out.println(productTypeList);
        Assertions.assertNotNull(productTypeList);
    }
}