package com.example.joole.model;

    import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<ProjectProduct> projectProductSet;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = Description.class)
    @JoinColumn(name = "description_id",referencedColumnName = "id")
    @JsonIgnore
    private Description description;

    @OneToOne(cascade = CascadeType.ALL,targetEntity = TechnicalDetail.class,fetch = FetchType.EAGER)
    @JsonIgnore
    private TechnicalDetail technicalDetail;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,targetEntity = ProductType.class)
    @JoinColumn(name = "prodType_id",referencedColumnName = "id")
    @JsonIgnore
    private ProductType productType;

    public Product() {

    }

    public Product(String productBrand, String certification, Set<ProjectProduct> projectProductSet, Description description, TechnicalDetail technicalDetail, ProductType productType) {
        this.productBrand = productBrand;
        this.certification = certification;
        this.projectProductSet = projectProductSet;
        this.description = description;
        this.technicalDetail = technicalDetail;
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

    public TechnicalDetail getTechnicalDetails() {
        return technicalDetail;
    }

    public void setTechnicalDetails(TechnicalDetail technicalDetail) {
        this.technicalDetail = technicalDetail;
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
                ", description=" + description +
                ", technicalDetails=" + technicalDetail +
                ", productType=" + productType +
                '}';
    }
}
