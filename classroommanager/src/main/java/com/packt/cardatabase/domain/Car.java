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


}
