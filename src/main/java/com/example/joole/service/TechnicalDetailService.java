package com.example.joole.service;

import com.example.joole.model.TechnicalDetails;

import java.util.List;

public interface TechnicalDetailService {
    TechnicalDetails saveTechnicalDetails(TechnicalDetails technicalDetails);

    List<TechnicalDetails> getTechnicalDetails();

    String deleteTechnicalDetails(long id);

    TechnicalDetails findTechnicalDetailById(Long id);
}
