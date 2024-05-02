package org.example.midterm.ServiceTest;


import org.example.midterm.model.Brand;
import org.example.midterm.model.Product;
import org.example.midterm.repository.BrandRepository;
import org.example.midterm.service.BrandService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BrandServiceTest {

    @Mock
    private BrandRepository brandRepository;

    @InjectMocks
    private BrandService brandService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllBrands() {
        List<Brand> expectedBrands = new ArrayList<>();
        expectedBrands.add(new Brand("Brand 1"));
        expectedBrands.add(new Brand("Brand 2"));
        expectedBrands.add(new Brand("Brand 3"));

        when(brandRepository.findAll()).thenReturn(expectedBrands);

        List<Brand> actualBrands = brandService.getAll();

        assertEquals(expectedBrands.size(), actualBrands.size());
        for (int i = 0; i < expectedBrands.size(); i++) {
            assertEquals(expectedBrands.get(i).getName(), actualBrands.get(i).getName());
        }
    }

    @Test
    void testGetBrandById() {
        Brand expectedBrand = new Brand("Test Brand");
        expectedBrand.setId(1L);

        when(brandRepository.findById(1L)).thenReturn(Optional.of(expectedBrand));

        ResponseEntity<Brand> responseEntity = brandService.getById(1L);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedBrand, responseEntity.getBody());
    }

    @Test
    void testGetBrandById_NotFound() {
        when(brandRepository.findById(1L)).thenReturn(Optional.empty());

        ResponseEntity<Brand> responseEntity = brandService.getById(1L);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    void testAddBrand_Success() {
        Brand newBrand = new Brand("New Brand");

        when(brandRepository.findByName("New Brand")).thenReturn(null);
        when(brandRepository.save(newBrand)).thenReturn(newBrand);

        ResponseEntity<Brand> responseEntity = brandService.addBrand(newBrand);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(newBrand, responseEntity.getBody());
    }

    @Test
    void testAddBrand_Failure() {
        Brand existingBrand = new Brand("Existing Brand");

        when(brandRepository.findByName("Existing Brand")).thenReturn(existingBrand);

        ResponseEntity<Brand> responseEntity = brandService.addBrand(existingBrand);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
        assertEquals(existingBrand, responseEntity.getBody());
    }
}
