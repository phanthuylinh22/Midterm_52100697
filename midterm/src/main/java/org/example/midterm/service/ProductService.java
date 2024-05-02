package org.example.midterm.service;

import org.example.midterm.DTO.ProductDTO;
import org.example.midterm.model.Brand;
import org.example.midterm.model.Product;
import org.example.midterm.repository.BrandRepository;
import org.example.midterm.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;

    public ProductService(BrandRepository brandRepository, ProductRepository productRepository) {
        this.brandRepository = brandRepository;
        this.productRepository = productRepository;
    }
    public List<Product> getAll() {
        return productRepository.findAll();
    }
    public List<Product> searchByName(String name) {
        return productRepository.findByName(name);
    }
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public ResponseEntity<Product> getById(Long id) {
        try {

            Optional<Product> fondProduct = productRepository.findById(id);

            // Nếu không tồn tại, trả về HTTP 404 Not Found
            return fondProduct.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            // Xử lý ngoại lệ và trả về HTTP 500 Internal Server Error
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<Product> addProduct(ProductDTO product) {
        Long idBrand = product.getBrand_id();
        Brand foundBrand = brandRepository.findById(idBrand).orElse(null);
        if (foundBrand == null) {
            return ResponseEntity.notFound().build();
        }
        Product newProduct = new Product();
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        newProduct.setColor(product.getColor());
        newProduct.setImage(product.getImage());
        newProduct.setBrand(foundBrand);
        return ResponseEntity.ok(productRepository.save(newProduct));
    }

    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        boolean exists = productRepository.existsById(id);
        Optional<Product> delProduct = productRepository.findById(id);

        if (exists && delProduct.isPresent()) {

            productRepository.deleteById(id);
            return ResponseEntity.ok(delProduct.get());
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Product> updateProduct(Product newProduct, Long id) {
        Product updateProduct= productRepository.findById(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setPrice(newProduct.getPrice());
                    product.setColor(newProduct.getColor());
                    product.setImage(newProduct.getImage());
                    return productRepository.save(product);
                }).orElseGet(() -> {
                    newProduct.setId(id);
                    return productRepository.save(newProduct);
                });
        return ResponseEntity.ok(updateProduct);
    }
}
