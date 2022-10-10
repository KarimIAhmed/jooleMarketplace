package com.example.joole.service.Impl;

import com.example.joole.model.TechnicalDetail;
import com.example.joole.repository.TechnicalDetailsRepository;
import com.example.joole.service.TechnicalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicalDetailServiceImpl implements TechnicalDetailService {
    @Autowired
    private TechnicalDetailsRepository technicalDetailsRepository;

    public TechnicalDetail createTechnicalDetail(TechnicalDetail technicalDetail){
        return technicalDetailsRepository.save(technicalDetail);
    }

    public List<TechnicalDetail> findTechnicalDetail(){
        return technicalDetailsRepository.findAll();
    }

    public TechnicalDetail findTechnicalDetailById(Long Id){
        return technicalDetailsRepository.findById(Id).orElse(null);
    }

    public String deleteTechnicalDetail(long id){
        technicalDetailsRepository.deleteById(id);
        return "Technical Detail " + id + " has been removed";
    }

}
