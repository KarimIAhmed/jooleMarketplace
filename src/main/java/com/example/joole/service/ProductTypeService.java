package com.example.joole.service;

import com.example.joole.model.ProductType;

import java.util.List;

public interface ProductTypeService {
    ProductType createProductType(ProductType productType);
    List<ProductType> findProductTypes();
    ProductType findProductTypeById(long Id);
    String deleteProductType(long id);
}
