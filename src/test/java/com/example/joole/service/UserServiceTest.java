package com.example.joole.service;

import com.example.joole.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;
    @Test
    void createUser() {
        User user=new User();
        user.setUserName("test");
        userService.createUser(user);
        System.out.println(user);
        Assertions.assertNotNull(userService);
    }

    @Test
    void findUser() {
        System.out.println(userService.findUser());
        Assertions.assertNotNull(userService.findUser());
    }

    @Test
    void findUserById() {
        User user=new User();
        user.setId(1L);
        userService.createUser(user);
        Assertions.assertNotNull(userService.findUserById(1L));
    }

}