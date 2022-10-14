package com.example.joole.service.Impl;

import com.example.joole.model.Product;
import com.example.joole.repository.ProductRepository;
import com.example.joole.repository.ProductTypeRepository;
import com.example.joole.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findProducts(){
        return productRepository.findAll();
    }

    public Product findProductById(long Id) {
        return productRepository.findById(Id).orElse(null);
    }

    public String deleteProduct(long id){
        productRepository.deleteById(id);
        return "product " + id + " has been removed";
    }

}
