package com.example.joole.repository;

import com.example.joole.model.Project;
import com.example.joole.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUserName(String username);
    Optional<List<User>> findByUserType(String userType);
    Optional<List<User>> findByUserProjectIn(Set<Project> userProject);

}
