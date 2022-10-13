package com.example.joole.repository;

import com.example.joole.model.Product;
import com.example.joole.model.Project;
import com.example.joole.model.ProjectProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectProductRepository extends JpaRepository<ProjectProduct,Long> {
    Optional<List<ProjectProduct>> findByProject(Project project);
    Optional<List<ProjectProduct>> findByProduct(Product product);
}
