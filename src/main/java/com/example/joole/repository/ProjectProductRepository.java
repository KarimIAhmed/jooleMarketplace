package com.example.joole.repository;

import com.example.joole.model.ProjectProduct;
import com.example.joole.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectProductRepository extends JpaRepository<ProjectProduct, Long> {
    Optional<ProjectProduct> findById(long projectProductId);
}
