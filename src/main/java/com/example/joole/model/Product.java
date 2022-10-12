package com.example.joole.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "productBrand")
    private String productBrand;

    @Column(name = "certification")
    private String certification;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ProjectProduct> projectProductSet;

    @OneToOne
    @JoinColumn(name = "id")
    private Description description;

    @OneToOne
    @JoinColumn(name = "id")
    private TechnicalDetails technicalDetails;

    @OneToOne
    @JoinColumn(name = "id")
    private ProductType productType;

    public Product() {

    }

    public Product(long id, String productBrand, String certification, Set<ProjectProduct> projectProductSet, Description description, TechnicalDetails technicalDetails, ProductType productType) {
        this.id = id;
        this.productBrand = productBrand;
        this.certification = certification;
        this.projectProductSet = projectProductSet;
        this.description = description;
        this.technicalDetails = technicalDetails;
        this.productType = productType;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public TechnicalDetails getTechnicalDetails() {
        return technicalDetails;
    }

    public void setTechnicalDetails(TechnicalDetails technicalDetails) {
        this.technicalDetails = technicalDetails;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Set<ProjectProduct> getProjectProductSet() {
        return projectProductSet;
    }

    public void setProjectProductSet(Set<ProjectProduct> projectProductSet) {
        this.projectProductSet = projectProductSet;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productBrand='" + productBrand + '\'' +
                ", certification='" + certification + '\'' +
                ", projectProductSet=" + projectProductSet +
                ", descriptionId=" + description +
                ", technicalDetailsId=" + technicalDetails.getId() +
                ", productTypeId=" + productType.getId() +
                '}';
    }
}
