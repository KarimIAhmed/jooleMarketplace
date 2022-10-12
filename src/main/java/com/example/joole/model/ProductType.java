package com.example.joole.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "productType")
public class ProductType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "application")
    private String application;

    @Column(name = "type")
    private String type;

    @Column(name = "mountain_location")
    private String mountain_location;

    @Column(name = "accessories")
    private String accessories;

    @Column(name = "model_year")
    private String model_year;

    @OneToOne
    @JoinColumn(name = "id")
    private Product product;

    public ProductType(){

    }

    public ProductType(long id, String application, String type, String mountain_location, String accessories, String model_year, Product product) {
        this.id = id;
        this.application = application;
        this.type = type;
        this.mountain_location = mountain_location;
        this.accessories = accessories;
        this.model_year = model_year;
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMountain_location() {
        return mountain_location;
    }

    public void setMountain_location(String mountain_location) {
        this.mountain_location = mountain_location;
    }

    public String getAccessories() {
        return accessories;
    }

    public void setAccessories(String accessories) {
        this.accessories = accessories;
    }

    public String getModel_year() {
        return model_year;
    }

    public void setModel_year(String model_year) {
        this.model_year = model_year;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "id=" + id +
                ", application='" + application + '\'' +
                ", type='" + type + '\'' +
                ", mountain_location='" + mountain_location + '\'' +
                ", accessories='" + accessories + '\'' +
                ", model_year='" + model_year + '\'' +
                ", productId=" + product.getId() +
                '}';
    }
}
