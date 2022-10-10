package com.example.joole.service;

import com.example.joole.model.Product;
import com.example.joole.model.User;
import com.example.joole.repository.ProductRepository;
import com.example.joole.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findOneById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public void createUser(int num){
        for(int i = 0; i < num; i++){
            User user = new User();
            user.setUserName("tengyang"+i);
            user.setUserType("customer");
            user.setUserPassword("123456");
            System.out.println(user);
            userRepository.save(user);
        }
    }


    public List<User> getUser(){
        return userRepository.findAll();
    }

    public String deleteUser(long id){
        userRepository.deleteById(id);
        return "product " + id + " has been removed";
    }


}
