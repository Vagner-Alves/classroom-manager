package com.packt.cardatabase.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
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
}
