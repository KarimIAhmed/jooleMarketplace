package com.example.joole.repository;

import com.example.joole.model.Product;
import com.example.joole.model.TechnicalDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TechnicalDetailsRepository extends JpaRepository<TechnicalDetails,Long> {

    Optional<TechnicalDetails> findById(long id);
    TechnicalDetails findByIdAndProduct(long id, Product product);
}
