package com.example.joole.service;

import com.example.joole.model.Description;
import com.example.joole.model.Product;
import com.example.joole.model.TechnicalDetail;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);
    List<Product> findProducts();
    Product findProductById(long Id);
    String deleteProduct(long id);
    List<Product> findByProductBrand(String productBrand);
    List <Product> findProductByTechnicalDetail(TechnicalDetail technicalDetail);
    List<Product> findByProductCertification(String certification);
    Product findProductByDescription(Description description);

    Product findProductByDescriptionIdAndTechnicalDetailIdAndProductTypeId(Long descriptionId, Long technicalDetailId, Long productTypeId);


}
