package com.example.joole.controller;

import com.example.joole.model.Project;
import com.example.joole.model.User;
import com.example.joole.service.ProjectService;
import com.example.joole.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @PostMapping("/createuser")
    public ResponseEntity<?> createUser(@RequestParam(name = "id") long id,
                                        @RequestParam(name = "userName") String userName,
                                        @RequestParam(name = "userType") String userType,
                                        @RequestParam(name = "userPassword") String userPassword) {
        userService.createUser(new User(id,userName,userType,userPassword,null));
        return ResponseEntity.ok("user has been created!");
    }

    @PutMapping("/updateusername")
    public ResponseEntity<?> updateUsernameByUserId(@RequestParam(name = "id") Long id, @RequestParam(name = "userName") String userName){
        User user = userService.findUserById(id);
        if (user == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User does not exist!");
        }
        user.setUserName(userName);
        return ResponseEntity.ok("username has been updated!");
    }

    @PutMapping("/updateusertype")
    public ResponseEntity<?> updateUserTypeByUserId(@RequestParam(name = "id") Long id, @RequestParam(name = "userType") String userType){
        User user = userService.findUserById(id);
        if (user == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User does not exist!");
        }
        user.setUserType(userType);
        return ResponseEntity.ok("user type has been updated!");
    }

    @PutMapping("/updateuserpassword")
    public ResponseEntity<?> updatePasswordByUserId(@RequestParam(name = "id") Long id, @RequestParam(name = "password") String password){
        User user = userService.findUserById(id);
        if (user == null){
            return new ResponseEntity<>(String.format("There is no such a user with id: %s", id), HttpStatus.BAD_REQUEST);
        }

        user.setUserPassword(password);

        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
    }

    @RequestMapping(path = "deleteuser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User " + id + " has been deleted!");
    }

    @PutMapping("/addUserProjectByUserId")
    public ResponseEntity<?> addUserProjectByUserId(@RequestParam(name = "id") Long id, @RequestBody Project project){
        User user = userService.findUserById(id);
        if (user == null){
            return new ResponseEntity<>(String.format("There is no such a user with id: %s", id), HttpStatus.BAD_REQUEST);
        }

        Set<Project> userProjectSet = user.getUserProject();
        if (userProjectSet.contains(project)){
            return new ResponseEntity<>("The user already has this project!", HttpStatus.BAD_REQUEST);
        }

        project.setUser(user);
        projectService.createProject(project);

        userProjectSet.add(project);

        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
    }

}
