package com.example.joole.service.Impl;

import com.example.joole.model.User;
import com.example.joole.repository.UserRepository;
import com.example.joole.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(User user){
       user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
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
