package com.example.joole.repository;

import com.example.joole.model.Description;
import com.example.joole.model.Project;
import com.example.joole.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByUserName() {
       // List<User> userList = userRepository.findByUserName("testUser").orElse(null);
        System.out.println(userRepository.findByUserName("testUser").orElse(null));
        Assertions.assertNotNull(userRepository.findByUserName("testUser").orElse(null));
    }


    @Test
    void findByUserType() {
        List<User> userList = userRepository.findByUserType("TestUserType").orElse(null);
        System.out.println(userList);
        Assertions.assertNotNull(userList);
    }

    @Test
    void findByUserProject() {
        Project project=new Project();
        project.setProjectId(3L);
        Set<Project> set= new HashSet<>();
        set.add(project);
        List<User> userList = userRepository.findByUserProjectIn(set).orElse(null);
        System.out.println(userList);
        Assertions.assertNotNull(userList);
    }
}