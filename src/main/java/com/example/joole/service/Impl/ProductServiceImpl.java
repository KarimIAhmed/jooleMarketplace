package com.example.joole.service.Impl;

import com.example.joole.model.Description;
import com.example.joole.model.Product;
import com.example.joole.model.TechnicalDetail;
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

    @Override
    public Product findProductByDescription(Description description) {
        return productRepository.findProductByDescription(description).orElse(null);
    }

    @Override
    public List<Product> findByProductBrand(String productBrand) {
        return productRepository.findByProductBrand(productBrand).orElse(null);
    }

    @Override
    public List<Product> findByProductCertification(String certification) {
        return productRepository.findByCertification(certification).orElse(null);
    }

    public List<Product> findProductByTechnicalDetail(TechnicalDetail technicalDetail) {
        return productRepository.findByTechnicalDetail(technicalDetail).orElse(null);
    }

    @Override
    public Product findProductByDescriptionIdAndTechnicalDetailIdAndProductTypeId(Long descriptionId, Long technicalDetailId, Long productTypeId) {
        return productRepository.findProductByDescriptionIdAndTechnicalDetailIdAndProductTypeId(descriptionId, technicalDetailId, productTypeId).orElse(null);
    }
}
