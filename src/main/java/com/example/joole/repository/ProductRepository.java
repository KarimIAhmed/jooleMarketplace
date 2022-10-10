package com.example.joole.repository;

import com.example.joole.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    Optional<Product> findById(long id);
    Optional<Product> findByIdAndProductBrand(long id,String productBrand);

}
