package org.example.midterm.model;


import jakarta.persistence.*;

@Entity
@Table
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private int name;

    @Column(name = "quantity")
    private int quantity;
    @Column(name = "desc")
    private int desc;

    public CartItem() {
    }

    public CartItem(Long id, int name, int quantity, int desc) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.desc = desc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDesc() {
        return desc;
    }

    public void setDesc(int desc) {
        this.desc = desc;
    }
}
