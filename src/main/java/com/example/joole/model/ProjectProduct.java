package com.example.joole.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "project_product")
public class ProjectProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Project.class)
    @JoinColumn(name = "project_id")
    @JsonIgnore
    private Project project;

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    public ProjectProduct() {
    }

    public ProjectProduct(Long id, Project project, Product product) {
        this.id = id;
        this.project = project;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProjectProduct{" +
                "Id=" + id +
                ", project=" + project +
                ", product=" + product +
                '}';
    }
}
