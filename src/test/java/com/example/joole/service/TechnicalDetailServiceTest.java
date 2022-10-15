package com.example.joole.service;

import com.example.joole.model.TechnicalDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class TechnicalDetailServiceTest {

    @Autowired
    private TechnicalDetailService technicalDetailService;

    @Test
    void createTechnicalDetail() {
        TechnicalDetail technicalDetail=new TechnicalDetail();
        technicalDetail.setFanSpeed(10);
        technicalDetailService.createTechnicalDetail(technicalDetail);
        System.out.println(technicalDetail);
        Assertions.assertNotNull(technicalDetailService);
    }

    @Test
    void findTechnicalDetail() {
        System.out.println(technicalDetailService.findTechnicalDetail());
        Assertions.assertNotNull(technicalDetailService.findTechnicalDetail());
    }

    @Test
    void findTechnicalDetailById() {
        TechnicalDetail technicalDetail=new TechnicalDetail();
        technicalDetail.setId(1);
        technicalDetailService.createTechnicalDetail(technicalDetail);
        Assertions.assertNotNull(technicalDetailService.findTechnicalDetailById(1L));
    }

    @Test
    void deleteTechnicalDetail() {
        TechnicalDetail technicalDetail=new TechnicalDetail();
        technicalDetail.setPower(2);
        technicalDetailService.createTechnicalDetail(technicalDetail);
        technicalDetailService.deleteTechnicalDetail(technicalDetail.getId());
        Assertions.assertNull(technicalDetailService.findTechnicalDetailById(technicalDetail.getId()));
    }
}