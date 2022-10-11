package com.example.joole.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "user_password")
    private String userPassword;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Project> userProject;

    public User() {
    }

    public User(Long id, String userName, String userType, String userPassword, Set<Project> userProject) {
        this.id = id;
        this.userName = userName;
        this.userType = userType;
        this.userPassword = userPassword;
        this.userProject = userProject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Set<Project> getUserProject() {
        return userProject;
    }

    public void setUserProject(Set<Project> userProject) {
        this.userProject = userProject;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userType='" + userType + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userProject=" + userProject +
                '}';
    }
}
