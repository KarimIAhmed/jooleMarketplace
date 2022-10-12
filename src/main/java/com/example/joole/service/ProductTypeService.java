package com.example.joole.service;

import com.example.joole.model.ProductType;

import java.util.List;

public interface ProductTypeService {
    ProductType saveProductType(ProductType productType);

    List<ProductType> getProductTypes();

    String deleteProductType(long id);
}
