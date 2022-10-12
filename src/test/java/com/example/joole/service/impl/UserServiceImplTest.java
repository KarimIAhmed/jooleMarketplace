package com.example.joole.service.impl;

import com.example.joole.model.Product;
import com.example.joole.model.Project;
import com.example.joole.model.ProjectProduct;
import com.example.joole.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    UserServiceImpl userService;

    @Test
    void createUser() {
        //Create a user object
        User user = new User();
        user.setUserName("Tengyang Zhang");
        user.setUserType("Customer");
        user.setUserPassword("123456");
        user.setId(1L);

        //Create three project obj
        Project project1 = new Project();
        project1.setUser(user);

        Project project2 = new Project();
        project2.setUser(user);

        Project project3 = new Project();
        project3.setUser(user);

        //Create a userProject set
        Set<Project> userProjectSet = new HashSet<>();
        userProjectSet.add(project1);
        userProjectSet.add(project2);
        userProjectSet.add(project3);

        //Set the userProject set to user
        user.setUserProject(userProjectSet);

        //Create user
        userService.createUser(user);

        //Create a product
        Product product = new Product();
        product.setProductBrand("Nike");
        product.setCertification("Certification of Nike!");

        //Create projectProduct obj
        ProjectProduct projectProduct = new ProjectProduct();
        projectProduct.setProduct(product);
        projectProduct.setProject(project1);

        //Create projectProduct set
        Set<ProjectProduct> projectProductSet = new HashSet<>();
        projectProductSet.add(projectProduct);

        //set projectProduct set to project1
        project1.setProjectProductSet(projectProductSet);

        //Set projectProduct set to product
        product.setProjectProductSet(projectProductSet);
    }

    @Test
    void findOneByID() {
        //Find user by ID

        System.out.println(userService.findOneByID(1L));
    }


    @Test
    void findAllByUserNameContaining() {
        //Find user by containing str
        System.out.println(userService.findAllByUserNameContaining("Teng"));
    }

    @Test
    void findUserByUserName() {
        //Find user by userName
        System.out.println(userService.findUserByUserName("Tengyang Zhang"));
    }
}