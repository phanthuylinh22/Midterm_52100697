package org.example.midterm.api;


import org.example.midterm.DTO.ProductDTO;
import org.example.midterm.model.Product;
import org.example.midterm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<Product> findById(@PathVariable Long id) {
        return productService.getById(id);
    }

    // Post
    @PostMapping("/insert")
    ResponseEntity<Product> insertProduct(@RequestBody ProductDTO newProduct) {
        return productService.addProduct(newProduct);
    }

    @PutMapping("/{id}")
    ResponseEntity<Product> updateProduct(@RequestBody Product newProduct, @PathVariable Long id) {
        return productService.updateProduct(newProduct, id);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Product> deleteBrand(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}
