package com.example.joole.service.impl;

import com.example.joole.model.User;
import com.example.joole.repository.UserRepository;
import com.example.joole.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findOneByID(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findAllByUserNameContaining(String containStr) {
        return userRepository.findAllByUserNameContaining(containStr).orElse(null);
    }

    @Override
    public User findUserByUserName(String name) {
        return userRepository.findUserByUserName(name).orElse(null);
    }

}
