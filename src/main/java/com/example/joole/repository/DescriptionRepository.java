package com.example.joole.repository;

import com.example.joole.model.Description;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DescriptionRepository extends JpaRepository<Description,Long> {

    Optional<Description> findById(long id);
    Optional<Description> findByIdAndManufacturer(long id,String manufacturer);

}
