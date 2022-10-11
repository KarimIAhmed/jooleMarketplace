package com.example.joole.repository;

import com.example.joole.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductTypeRepository extends JpaRepository<ProductType,Long> {

    Optional<List<ProductType>> findByApplication(String application);
    Optional<List<ProductType>> findByType(String type);
    Optional<List<ProductType>> findByMountingLocation(String mountingLocation);
    Optional<List<ProductType>> findByAccessories(String accessories);
    Optional<List<ProductType>> findByModelYear(int modelYear);

}
