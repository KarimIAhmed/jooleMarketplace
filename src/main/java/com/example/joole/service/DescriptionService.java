package com.example.joole.service;

import com.example.joole.model.Description;

import java.util.List;

public interface DescriptionService {

    Description findById(Long id);
    Description saveDescription(Description description);
    List<Description> findAllByManufacturer(String manufacturer);
    Description findDescriptionByProductId(Long id);
}
