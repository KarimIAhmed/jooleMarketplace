package com.example.joole;

import com.example.joole.model.User;
import com.example.joole.service.ProjectService;
import com.example.joole.service.UserService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JooleApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    ProjectService projectService;

    @Test
    void contextLoads() {
    }

    @Test
    public void userServiceTest(){

        userService.createUser(3);

        System.out.println(userService.getUser());
    }

    @Test
    public void projectServiceTest(){
        projectService.createProject(userService.findOneById(1L));

        System.out.println(projectService.getProject());
    }

}
