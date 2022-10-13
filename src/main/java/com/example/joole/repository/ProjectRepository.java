package com.example.joole.repository;

import com.example.joole.model.Project;
import com.example.joole.model.ProjectProduct;
import com.example.joole.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProjectRepository extends JpaRepository<Project,Long> {
    Optional<List<Project>> findByUser(User user);
    Optional<List<Project>> findByProjectProductSet(ProjectProduct projectProduct);


}
