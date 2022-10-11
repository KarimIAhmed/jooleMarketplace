package com.example.joole.repository;

import com.example.joole.model.TechnicalDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TechnicalDetailRepositoryTest {

    @Autowired
    private TechnicalDetailRepository technicalDetailRepository;

    /*
    @BeforeAll
    static void create() {
        TechnicalDetail technicalDetail= new TechnicalDetail();
        technicalDetail.setAirflow(1);
        technicalDetail.setPower(1);
        technicalDetail.setOperatingVoltage(1);
        technicalDetail.setFanSpeed(1);
    }
    */

    @Test
    void findByAirflow() {
        List<TechnicalDetail> technicalDetailList = technicalDetailRepository.findByAirflow(1).orElse(null);
        System.out.println(technicalDetailList);
        Assertions.assertNotNull(technicalDetailList);
    }

    @Test
    void findByPower() {
        List<TechnicalDetail> technicalDetailList = technicalDetailRepository.findByPower(1).orElse(null);
        System.out.println(technicalDetailList);
        Assertions.assertNotNull(technicalDetailList);
    }

    @Test
    void findByOperatingVoltage() {
        List<TechnicalDetail> technicalDetailList = technicalDetailRepository.findByOperatingVoltage(1).orElse(null);
        System.out.println(technicalDetailList);
        Assertions.assertNotNull(technicalDetailList);
    }

    @Test
    void findByFanSpeed() {
        List<TechnicalDetail> technicalDetailList = technicalDetailRepository.findByFanSpeed(1).orElse(null);
        System.out.println(technicalDetailList);
        Assertions.assertNotNull(technicalDetailList);
    }
}