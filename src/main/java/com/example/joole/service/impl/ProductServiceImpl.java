package com.example.joole.service.impl;

import com.example.joole.model.Product;
import com.example.joole.repository.ProductRepository;
import com.example.joole.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product){

        return productRepository.save(product);
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public String deleteProduct(long id){
        productRepository.deleteById(id);
        return "product " + id + " has been removed";
    }

    @Override
    public Product findProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findProductsByProductBrand(String brand) {
        return productRepository.findAllByProductBrand(brand);
    }
}
