package org.example.midterm.service;

import org.example.midterm.model.Brand;
import org.example.midterm.model.Product;
import org.example.midterm.repository.BrandRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BrandService {
    private final BrandRepository brandRepository;
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public List<Brand> getAll() {
        return brandRepository.findAll();
    }
    public List<Product> findById(Long id) {
        Brand fondBrand = brandRepository.findById(id).orElse(null);
        List<Product> productList = new ArrayList<>(fondBrand.getProducts());
        return productList;
    }

    public ResponseEntity<Brand> getById(Long id) {
        Optional<Brand> foundProduct = brandRepository.findById(id);
        return foundProduct.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Brand> addBrand(Brand newBrand) {
        Brand foundProducts = brandRepository.findByName(newBrand.getName().trim());
        return foundProducts != null ?
                ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(foundProducts):
                ResponseEntity.ok(brandRepository.save(newBrand));
    }
}
