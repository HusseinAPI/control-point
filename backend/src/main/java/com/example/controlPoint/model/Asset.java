package com.example.controlPoint.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity // define the class as table in H2
public class Asset {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment id
    private Long id;
    private String name;
    private String type;
    private String status;

    public Asset(){}

    public Asset(String name, String type, String status) {
        this.name = name;
        this.type = type;
        this.status = status;
    }

    // get & set
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
