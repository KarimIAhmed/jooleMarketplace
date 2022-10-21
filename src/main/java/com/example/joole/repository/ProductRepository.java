package com.example.joole.repository;

import com.example.joole.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    Optional<List<Product>> findByProductBrand(String productBrand);

    Optional<List<Product>> findByCertification(String certification);

    Optional<List<Product>> findByProductType(ProductType productType);

    Optional<List<Product>> findByTechnicalDetail(TechnicalDetail technicalDetail);

    Optional<Product> findProductByDescription(Description description);


    Optional<Product> findProductByDescriptionIdAndTechnicalDetailIdAndProductTypeId(Long descriptionId, Long technicalDetailId, Long productTypeId);

    Optional<Product> findProductByProjectProductSetContaining(ProjectProduct projectProduct);
}
