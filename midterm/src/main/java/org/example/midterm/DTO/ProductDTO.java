package org.example.midterm.DTO;


import org.example.midterm.model.Product;

public class ProductDTO {
    private String name;
    private Long price;
    private String color;
    private String image;
    private Long brand_id;
    public ProductDTO(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.color = product.getColor();
        this.image = product.getImage();
        this.brand_id = product.getBrand().getId();
    }

    public ProductDTO(String name, Long price, String color, String image, Long brand_id) {
        this.name = name;
        this.price = price;
        this.color = color;
        this.image = image;
        this.brand_id = brand_id;
    }

    public ProductDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
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

    public Long getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Long brand_id) {
        this.brand_id = brand_id;
    }
}
