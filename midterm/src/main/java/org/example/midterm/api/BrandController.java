package org.example.midterm.api;


import org.example.midterm.model.Brand;
import org.example.midterm.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/brands")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping("")
    List<Brand> getAll() {
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<Brand> findById(@PathVariable Long id) {
        return brandService.getById(id);
    }

    // Post
    @PostMapping("/insert")
    ResponseEntity<Brand> insertBrand(@RequestBody Brand newBrand) {
        return brandService.addBrand(newBrand);
    }
}
