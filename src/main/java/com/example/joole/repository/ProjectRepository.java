package com.example.joole.repository;

import com.example.joole.model.Product;
import com.example.joole.model.Project;
import com.example.joole.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    Optional<Project> findById(long projectId);
}
