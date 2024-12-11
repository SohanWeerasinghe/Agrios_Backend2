package com.example.Agrios_Product.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "vegetable_price")
public class VegetablePrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // Name of the vegetable

    @Column(nullable = false)
    private double price; // Price of the vegetable

    @Column(nullable = false)
    private LocalDate date; // Date of the price record

    // Default constructor
    public VegetablePrice() {
    }

    // Parameterized constructor
    public VegetablePrice(String name, double price, LocalDate date) {
        this.name = name;
        this.price = price;
        this.date = date;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "VegetablePrice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
