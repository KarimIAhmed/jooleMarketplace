package com.example.joole.service;

import com.example.joole.model.ProductType;
import com.example.joole.repository.ProductTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService {

    private ProductTypeRepository productTypeRepository;

    public ProductType saveProductType(ProductType productType){
        return productTypeRepository.save(productType);
    }

    public List<ProductType> getProductTypes(){
        return productTypeRepository.findAll();
    }

    public String deleteProductType(long id){
        productTypeRepository.deleteById(id);
        return "product type " + id + " has been removed";
    }
}
