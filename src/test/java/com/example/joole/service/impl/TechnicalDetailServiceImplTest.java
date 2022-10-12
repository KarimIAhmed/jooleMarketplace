package com.example.joole.service.impl;

import com.example.joole.model.TechnicalDetails;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TechnicalDetailServiceImplTest {

    @Autowired
    TechnicalDetailServiceImpl technicalDetailService;

    @Autowired
    ProductServiceImpl productService;

    @Test
    void saveTechnicalDetails() {
        TechnicalDetails technicalDetails = new TechnicalDetails();
        technicalDetails.setAirflow(1);
        technicalDetails.setFanSpeed(50);
        technicalDetails.setPower(110);
        technicalDetails.setOperatingVoltage(3);
        technicalDetails.setProduct(productService.findProductById(7L));

        technicalDetailService.saveTechnicalDetails(technicalDetails);
    }

    @Test
    void getTechnicalDetails() {
        System.out.println(technicalDetailService.getTechnicalDetails());
    }

    @Test
    void deleteTechnicalDetails() {
        technicalDetailService.deleteTechnicalDetails(1L);
    }
}