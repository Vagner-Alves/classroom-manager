package com.packt.cardatabase.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Car {
    @Id
    @GeneratedValue
    private long id;
    private String brand, model, color, registrationNumber;
    private int modelYear, price;


}
