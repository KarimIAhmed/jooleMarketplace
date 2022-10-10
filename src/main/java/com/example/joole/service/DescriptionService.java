package com.example.joole.service;

import com.example.joole.model.Description;
import com.example.joole.repository.DescriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DescriptionService {
    private DescriptionRepository descriptionRepository;

    public Description saveDescription(Description description){
        return descriptionRepository.save(description);
    }

    public List<Description> getProducts(){
        return descriptionRepository.findAll();
    }

    public String deleteProduct(long id){
        descriptionRepository.deleteById(id);
        return "DescriptionService " + id + " has been removed";
    }
}
