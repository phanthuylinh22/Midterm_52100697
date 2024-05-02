package org.example.midterm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
@Table

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name",nullable = false, length = 30)
    private String name;

    @Column(name = "price",nullable = false)
    private long price;
    
    @Column(name ="color", nullable = false)
    private String color;

    @Column(name = "image", nullable = false)
    private  String image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id", nullable = false)
    @JsonIgnore
    private Brand brand;

    public Product(long id, String name, long price, String color, String image, Brand brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.color = color;
        this.image = image;
        this.brand = brand;
    }

    public Product(long id, String name, long price, String color, String image) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.color = color;
        this.image = image;
    }

    public Product() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
