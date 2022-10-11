package com.example.joole.service.impl;

import com.example.joole.model.TechnicalDetails;
import com.example.joole.repository.TechnicalDetailsRepository;
import com.example.joole.service.TechnicalDetailService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicalDetailServiceImpl implements TechnicalDetailService {
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

}
