package com.example.joole.controller;

import com.example.joole.model.Project;
import com.example.joole.model.Role;
import com.example.joole.model.User;
import com.example.joole.service.MyUserDetailsService;
import com.example.joole.service.ProjectService;
import com.example.joole.service.UserService;
import com.example.joole.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private AuthenticationManager myAuthenticationManager;
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private ProjectService projectService;

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestParam(name = "userName") String userName,
                                        @RequestParam(name = "userPassword") String userPassword) {
        if(userService.findUserByUsername(userName)) return new ResponseEntity<>("User already created!", HttpStatus.BAD_REQUEST);

        User user=new User(userName,"user",userPassword,null);
        user.setRole(Role.USER);
        userService.createUser(user);

        return ResponseEntity.ok("user has been created!");
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestParam(name="username") String username,
                                                       @RequestParam(name="password") String password)
        //@RequestBody User User)
            throws Exception {

        try {
            myAuthenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username,password)//User.getUsername(), User.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }


        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(username);

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return new ResponseEntity<>(jwt, HttpStatus.OK);
    }

    @PutMapping("/updateUsername")
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

    @PutMapping("/updateUserPassword")
    public ResponseEntity<?> updatePasswordByUserId(@RequestParam(name = "id") Long id, @RequestParam(name = "password") String password){
        User user = userService.findUserById(id);
        if (user == null){
            return new ResponseEntity<>(String.format("There is no such a user with id: %s", id), HttpStatus.BAD_REQUEST);
        }

        user.setUserPassword(password);

        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
    }

    @RequestMapping(path = "/deleteUser/{id}")
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
