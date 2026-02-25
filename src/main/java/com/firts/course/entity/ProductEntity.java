package com.firts.course.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "producto")
public class ProductEntity {

    // Encapsulamiento

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int quantity;
    private double price;
    private boolean available;

    @ManyToOne(fetch = FetchType.LAZY)
    private CategoryEntity category;

    public ProductEntity(String name, int quantity, double price, boolean available) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.available = available;
    }
}