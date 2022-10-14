package com.example.joole.service.Impl;

import com.example.joole.model.ProductType;
import com.example.joole.repository.ProductTypeRepository;
import com.example.joole.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepository;

    public ProductType createProductType(ProductType productType){
        return productTypeRepository.save(productType);
    }

    public List<ProductType> findProductTypes(){
        return productTypeRepository.findAll();
    }

    @Override
    public ProductType findProductTypeById(long Id) {
         return productTypeRepository.findById(Id).orElse(null);
    }


    public String deleteProductType(long id){
        productTypeRepository.deleteById(id);
        return "product type " + id + " has been removed";
    }
}
