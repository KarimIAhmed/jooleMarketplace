package com.example.joole.repository;

import com.example.joole.model.Project;
import com.example.joole.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findAllByUserNameContaining(String containStr);

    Optional<User> findUserByUserName(String name);
}
