package com.example.joole.repository;

import com.example.joole.model.Product;
import com.example.joole.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(long id);
    User findByIdAndUserType(long id,String userType);
}
