package org.example.midterm.service;


import org.example.midterm.model.ProductInCart;
import org.example.midterm.repository.CartItemRepositoty;
import org.example.midterm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Service
public class CartService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CartItemRepositoty cartItemRepositoty;

//    Cart
    Map<Long, ProductInCart> maps = new HashMap<>();

    public void add(ProductInCart product) {
        ProductInCart cartProduct = maps.get(product.getProductId());
        if (cartProduct == null) {
            maps.put(product.getProductId(), product);
        } else {
            cartProduct.plusQuantity();
        }
    }


    public void minus(ProductInCart product) {
        ProductInCart cartProduct = maps.get(product.getProductId());
        if (cartProduct != null) {
            cartProduct.minusQuantity();
            if(cartProduct.getQuantity() == 0) {
                remove(cartProduct.getProductId());
            }
        }
    }

    public void remove(Long id) {
        maps.remove(id);
    }


    public void clear() {
        maps.clear();
    }


    public Collection<ProductInCart> getAllProducts() {
        return maps.values();
    }

    public Map<Long, ProductInCart> getAllProductss() {
        return maps;
    }

    public int getCount() {
        return maps.values().size();
    }

    public Long getAmount() {
        return maps.values().stream()
                .mapToLong(product -> (long) product.getQuantity() * product.getProductDTO().getPrice())
                .sum();
    }
}