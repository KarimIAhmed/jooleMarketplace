package com.example.joole.controller;

import com.example.joole.model.User;
import com.example.joole.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.findUser();
    }
    @PostMapping("/createuser")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @RequestMapping(path = "deleteuser/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return "User " + id + " has been deleted!";
    }


}
