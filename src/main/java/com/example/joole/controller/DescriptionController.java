package com.example.joole.controller;

import com.example.joole.model.Description;
import com.example.joole.model.Product;
import com.example.joole.repository.DescriptionRepository;
import com.example.joole.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/descriptions")
public class DescriptionController {

    @Autowired
    private DescriptionRepository descriptionRepository;

    //get all products
    @GetMapping("/description")
    public List<Description> getAllProducts(){
        return descriptionRepository.findAll();
    }

    @PostMapping
    public Description createProduct(@RequestBody Description description){
        return descriptionRepository.save(description);
    }
}
