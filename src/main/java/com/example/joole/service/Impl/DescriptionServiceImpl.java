package com.example.joole.service.Impl;

import com.example.joole.model.Description;
import com.example.joole.model.Product;
import com.example.joole.repository.DescriptionRepository;
import com.example.joole.repository.ProductRepository;
import com.example.joole.service.DescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DescriptionServiceImpl implements DescriptionService {
    @Autowired
    private DescriptionRepository descriptionRepository;

    public Description createDescription(Description description){
        return descriptionRepository.save(description);
    }

    public List<Description> findDescription(){
        return descriptionRepository.findAll();
    }

    public Description findDescriptionById(long Id){
        return descriptionRepository.findById(Id).orElse(null);
    }

    public List<Description> findBySeries(String series) {
        return descriptionRepository.findBySeries(series).orElse(null);
    }
    public String deleteDescription(long id){
        descriptionRepository.deleteById(id);
        return "description " + id + " has been removed";
    }


}
