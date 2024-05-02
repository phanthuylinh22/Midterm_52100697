package org.example.midterm.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.example.midterm.DTO.ProductDTO;


public class ProductInCart {
    private Long productId;
    private ProductDTO productDTO;
    private int quantity = 1;

    public void plusQuantity() {
        this.quantity += 1;
    }

    public void minusQuantity() {
        this.quantity -= 1;
    }

    public ProductInCart() {
    }



    public ProductInCart(Long productId, ProductDTO productDTO, int quantity) {
        this.productId = productId;
        this.productDTO = productDTO;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
