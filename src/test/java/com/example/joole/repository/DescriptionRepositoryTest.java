package com.example.joole.repository;

import com.example.joole.model.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DescriptionRepositoryTest {
    @Autowired
    private DescriptionRepository descriptionRepository;


    /*
    @BeforeAll
    static void create() {
        Description description1 = new Description();
        description1.setManufacturer("testManufacturer");
        description1.setSeries("testSeries");
        description1.setModel("testModel");
    }*/

    @Test
    void findByManufacturer() {
        List<Description> descriptionList = descriptionRepository.findByManufacturer("testManufacturer").orElse(null);
        System.out.println(descriptionList);
        Assertions.assertNotNull(descriptionList);
    }

    @Test
    void findBySeries() {
        List<Description> SeriesList = descriptionRepository.findBySeries("testSeries").orElse(null);
        System.out.println(SeriesList);
        Assertions.assertNotNull(SeriesList);
    }

    @Test
    void findByModel() {
        List<Description> ModelList = descriptionRepository.findByModel("testModel").orElse(null);
        System.out.println(ModelList);
        Assertions.assertNotNull(ModelList);
    }
}


