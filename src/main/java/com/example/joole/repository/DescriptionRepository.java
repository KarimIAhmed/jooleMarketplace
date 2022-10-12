package com.example.joole.repository;

import com.example.joole.model.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DescriptionRepository extends JpaRepository<Description,Long> {

    List<Description> findAllByManufacturer(String manufacturer);

    Optional<Description> findDescriptionByProductId(Long id);
}
