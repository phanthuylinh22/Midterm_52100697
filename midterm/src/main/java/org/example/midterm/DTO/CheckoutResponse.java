package org.example.midterm.DTO;

import org.example.midterm.model.ProductInCart;

import java.util.List;

public class CheckoutResponse {
    private List<ProductInCart> cartProducts;
    private int quantityCart;
    private Long total;

    // Constructor
    public CheckoutResponse(List<ProductInCart> cartProducts, int quantityCart, Long total) {
        this.cartProducts = cartProducts;
        this.quantityCart = quantityCart;
        this.total = total;
    }

    // Getters and setters
    public List<ProductInCart> getCartProducts() {
        return cartProducts;
    }

    public void setCartProducts(List<ProductInCart> cartProducts) {
        this.cartProducts = cartProducts;
    }

    public int getQuantityCart() {
        return quantityCart;
    }

    public void setQuantityCart(int quantityCart) {
        this.quantityCart = quantityCart;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
