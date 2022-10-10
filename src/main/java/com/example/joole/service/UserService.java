package com.example.joole.service;

import com.example.joole.model.Product;
import com.example.joole.model.User;
import com.example.joole.repository.ProductRepository;
import com.example.joole.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public List<User> getUser(){
        return userRepository.findAll();
    }

    public String deleteUser(long id){
        userRepository.deleteById(id);
        return "product " + id + " has been removed";
    }



//////////////////////////////////////////////////////////////////////////////

    private List<User> users;

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUser(long id){
        return users.stream().filter(c-> c.getId() == id).findFirst().get();
    }
}
