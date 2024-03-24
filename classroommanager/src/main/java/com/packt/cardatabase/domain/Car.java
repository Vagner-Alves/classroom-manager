package com.packt.cardatabase.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue
    private long id;
    private String brand, model, color, registrationNumber;
    private int modelYear, price;

    @Column(name="explanation",nullable =true, length =512)
    private String description;

    public Car() {
    }
    public Car(String brand, String model, String color,
               String registrationNumber, int modelYear, int price) {
        super();
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.registrationNumber = registrationNumber;
        this.modelYear = modelYear;
        this.price = price;
    }


}
