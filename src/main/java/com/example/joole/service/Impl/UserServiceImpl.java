package com.example.joole.service.Impl;

import com.example.joole.model.User;
import com.example.joole.repository.UserRepository;
import com.example.joole.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
       return userRepository.save(user);
    }
    public List<User> findUser(){
        return userRepository.findAll();
    }
    public User findUserById(long Id){
        return userRepository.findById(Id).orElse(null);
    }
    public String deleteUser(long id){
        userRepository.deleteById(id);
        return "User " + id + " has been removed";
    }
}
