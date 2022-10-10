package com.example.joole.repository;

import com.example.joole.model.Product;
import com.example.joole.model.TechnicalDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TechnicalDetailsRepository extends JpaRepository<TechnicalDetail,Long> {

    Optional<TechnicalDetail> findById(long id);
    Optional<TechnicalDetail> findByIdAndProduct(long id, Product product);
}
