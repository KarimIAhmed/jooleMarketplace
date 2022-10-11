package com.example.joole.repository;

import com.example.joole.model.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DescriptionRepository extends JpaRepository<Description,Long> {
    Optional<List<Description>> findByManufacturer(String manufacturer);
    Optional<List<Description>> findBySeries(String series);
    Optional<List<Description>> findByModel(String model);

}
