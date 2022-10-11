package com.example.joole.service.Impl;

import com.example.joole.model.TechnicalDetail;
import com.example.joole.repository.TechnicalDetailRepository;
import com.example.joole.service.TechnicalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicalDetailServiceImpl implements TechnicalDetailService {
    @Autowired
    private TechnicalDetailRepository technicalDetailRepository;

    public TechnicalDetail createTechnicalDetail(TechnicalDetail technicalDetail){
        return technicalDetailRepository.save(technicalDetail);
    }

    public List<TechnicalDetail> findTechnicalDetail(){
        return technicalDetailRepository.findAll();
    }

    public TechnicalDetail findTechnicalDetailById(Long Id){
        return technicalDetailRepository.findById(Id).orElse(null);
    }

    public String deleteTechnicalDetail(long id){
        technicalDetailRepository.deleteById(id);
        return "Technical Detail " + id + " has been removed";
    }

}
