package com.example.joole.service;

import com.example.joole.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> findUser();
    User findUserById(long Id);
    String deleteUser(long id);
}
