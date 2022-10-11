package com.example.joole.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "technicalDetails")
public class TechnicalDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="airflow")
    private int airflow;
    @Column(name = "power")
    private int power;
    @Column(name = "operatingVoltage")
    private int operatingVoltage;
    @Column(name = "fanSpeed")
    private int fanSpeed;

    @OneToOne(mappedBy="technicalDetail",
            cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
                    CascadeType.REFRESH})
    @JsonIgnore
    private Product product;

    public TechnicalDetail() {

    }

    public TechnicalDetail(long id, int airflow, int power, int operatingVoltage, int fanSpeed, Product product) {
        this.id = id;
        this.airflow = airflow;
        this.power = power;
        this.operatingVoltage = operatingVoltage;
        this.fanSpeed = fanSpeed;
        this.product = product;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAirflow() {
        return airflow;
    }

    public void setAirflow(int airflow) {
        this.airflow = airflow;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getOperatingVoltage() {
        return operatingVoltage;
    }

    public void setOperatingVoltage(int operatingVoltage) {
        this.operatingVoltage = operatingVoltage;
    }

    public int getFanSpeed() {
        return fanSpeed;
    }

    public void setFanSpeed(int fanSpeed) {
        this.fanSpeed = fanSpeed;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "TechnicalDetails{" +
                "id=" + id +
                ", airflow=" + airflow +
                ", power=" + power +
                ", operatingVoltage=" + operatingVoltage +
                ", fanSpeed=" + fanSpeed +
                ", product=" + product +
                '}';
    }
}

