package com.example.joole.repository;

import com.example.joole.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findAllByProductBrand(String Brand);


}
