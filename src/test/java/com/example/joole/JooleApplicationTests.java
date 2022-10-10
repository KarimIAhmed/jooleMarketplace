package com.example.joole;

import com.example.joole.service.Impl.ProjectServiceImpl;
import com.example.joole.service.Impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JooleApplicationTests {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    ProjectServiceImpl projectService;

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
