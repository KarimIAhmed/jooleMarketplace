package com.example.joole.service;

import com.example.joole.model.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DescriptionServiceTest {

    @Autowired
    private DescriptionService descriptionService;

    @Test
    void createDescription() {
        Description description=new Description();
        description.setModel("test");
        descriptionService.createDescription(description);
        System.out.println(description);
        Assertions.assertNotNull(descriptionService);
    }

    @Test
    void findDescription() {
        System.out.println(descriptionService.findDescription());
        Assertions.assertNotNull(descriptionService.findDescription());
    }

    @Test
    void findDescriptionById() {
        Description description=new Description();
        description.setId(1);
        descriptionService.createDescription(description);
        Assertions.assertNotNull(descriptionService.findDescriptionById(1));
    }

    @Test
    void deleteDescription() {
        Description description=new Description();
        description.setId(4);
        descriptionService.createDescription(description);
        descriptionService.deleteDescription(description.getId());
        Assertions.assertNull(descriptionService.findDescriptionById(99999));
    }
}