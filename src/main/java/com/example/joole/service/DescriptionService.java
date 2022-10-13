package com.example.joole.service;

import com.example.joole.model.Description;

import java.util.List;

public interface DescriptionService {
    Description createDescription(Description description);
    List<Description> findDescription();
    Description findDescriptionById(long Id);
    String deleteDescription(long id);
}
