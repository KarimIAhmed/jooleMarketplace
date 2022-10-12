package com.example.joole.service.implementation;

import com.example.joole.model.Description;
import com.example.joole.repository.DescriptionRepository;
import com.example.joole.service.DescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DescriptionServiceImpl implements DescriptionService {
    @Autowired
    private DescriptionRepository descriptionRepository;

    public Description saveDescription(Description description){
        return descriptionRepository.save(description);
    }

    @Override
    public Description findById(Long id) {
        return descriptionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Description> findAllByManufacturer(String manufacturer) {
        return descriptionRepository.findAllByManufacturer(manufacturer);
    }

    @Override
    public Description findDescriptionByProductId(Long id) {
        return descriptionRepository.findDescriptionByProductId(id).orElse(null);
    }
}
