package com.example.joole.model;

import javax.persistence.*;

@Entity
@Table(name = "project_product")
public class ProjectProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectProductId;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "id")
    private Product product;

    public ProjectProduct() {
    }

    public ProjectProduct(Long projectProductId, Project project, Product product) {
        this.projectProductId = projectProductId;
        this.project = project;
        this.product = product;
    }

    public Long getProjectProductId() {
        return projectProductId;
    }

    public void setProjectProductId(Long projectProductId) {
        this.projectProductId = projectProductId;
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
                "projectProductId=" + projectProductId +
                ", projectId=" + project.getProjectId() +
                ", productId=" + product.getId() +
                '}';
    }
}
