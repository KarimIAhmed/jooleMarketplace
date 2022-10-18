package com.example.joole.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = ProjectProduct.class)
    private Set<ProjectProduct> projectProductSet;

    public Project() {
    }

    public Project(Long projectId, User user, Set<ProjectProduct> projectProductSet) {
        this.projectId = projectId;
        this.user = user;
        this.projectProductSet = projectProductSet;
    }


    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<ProjectProduct> getProjectProductSet() {
        return projectProductSet;
    }

    public void setProjectProductSet(Set<ProjectProduct> projectProductSet) {
        this.projectProductSet = projectProductSet;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", user=" + user +
                '}';
    }
}
