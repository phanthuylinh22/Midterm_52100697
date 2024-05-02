package org.example.midterm.model;


import jakarta.persistence.*;


import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Brand {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @Column(name = "name",nullable = false, length = 30)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand")
    private Set<Product> products = new HashSet<>(0);

    public Brand(String name) {
        this.name = name;
    }

    public Brand(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Brand(long id, String name, Set<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public Brand() {
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

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}