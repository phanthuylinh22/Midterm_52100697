package org.example.midterm.ServiceTest;

import org.example.midterm.DTO.ProductDTO;
import org.example.midterm.model.Brand;
import org.example.midterm.model.Product;
import org.example.midterm.repository.BrandRepository;
import org.example.midterm.repository.ProductRepository;
import org.example.midterm.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class ProductServiceTest {

    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private BrandRepository brandRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        productService = new ProductService(brandRepository, productRepository);
    }

    @Test
    public void testGetAllProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product());
        when(productRepository.findAll()).thenReturn(products);
        List<Product> result = productService.getAll();
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void testGetProductById() {
        Long productId = 1L;
        Product product = new Product();
        product.setId(productId);
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
        ResponseEntity<Product> responseEntity = productService.getById(productId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(productId, responseEntity.getBody().getId());
    }

    @Test
    public void testGetProductByIdNotFound() {
        Long productId = 1L;
        when(productRepository.findById(productId)).thenReturn(Optional.empty());
        ResponseEntity<Product> responseEntity = productService.getById(productId);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

    @Test
    public void testAddProduct() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("Test Product");
        productDTO.setPrice(100L);
        productDTO.setColor("Red");
        productDTO.setImage("test.jpg");
        productDTO.setBrand_id(1L);

        Brand brand = new Brand();
        brand.setId(1L);
        when(brandRepository.findById(1L)).thenReturn(Optional.of(brand));

        Product savedProduct = new Product();
        savedProduct.setId(1L);
        when(productRepository.save(any())).thenReturn(savedProduct);

        ResponseEntity<Product> responseEntity = productService.addProduct(productDTO);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(savedProduct.getId(), responseEntity.getBody().getId());
    }

    // Add more tests for other methods such as searchByName, updateProduct, deleteProduct, etc.
}
