package com.example.joole.service.impl;

import com.example.joole.model.TechnicalDetails;
import com.example.joole.repository.TechnicalDetailsRepository;
import com.example.joole.service.TechnicalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicalDetailServiceImpl implements TechnicalDetailService {
    @Autowired
    private TechnicalDetailsRepository technicalDetailsRepository;

    public TechnicalDetails saveTechnicalDetails(TechnicalDetails technicalDetails){
        return technicalDetailsRepository.save(technicalDetails);
    }

    public List<TechnicalDetails> getTechnicalDetails(){
        return technicalDetailsRepository.findAll();
    }

    public String deleteTechnicalDetails(long id){
        technicalDetailsRepository.deleteById(id);
        return "Technical Detail " + id + " has been removed";
    }

    @Override
    public TechnicalDetails findTechnicalDetailById(Long id) {
        return technicalDetailsRepository.findById(id).orElse(null);
    }

}
