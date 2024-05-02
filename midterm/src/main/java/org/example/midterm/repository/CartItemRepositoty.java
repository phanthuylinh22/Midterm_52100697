package org.example.midterm.repository;

import org.example.midterm.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepositoty extends JpaRepository<CartItem, Long> {
}
