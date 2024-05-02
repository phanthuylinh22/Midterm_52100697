package org.example.midterm.ServiceTest;



import org.example.midterm.model.Brand;
import org.example.midterm.model.Product;
import org.example.midterm.DTO.ProductDTO;
import org.example.midterm.model.ProductInCart;
import org.example.midterm.repository.CartItemRepositoty;
import org.example.midterm.repository.ProductRepository;
import org.example.midterm.service.CartService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CartServiceTest {

    private CartService cartService;

    @BeforeEach
    void setUp() {
        cartService = new CartService();
    }

    @Test
    void testAddProductToCart() {
        Brand brand1 = new Brand(1L,"Chanel");
        Brand brand2 = new Brand(2L,"Dior");
        ProductDTO productDTO1 = new ProductDTO(new Product(1L,"Product 1", 10, "Red", "image1.jpg",brand1));
        ProductDTO productDTO2 = new ProductDTO(new Product(2L,"Product 2", 20, "Blue", "image2.jpg",brand2));

        ProductInCart productInCart1 = new ProductInCart(1L, productDTO1,1);
        ProductInCart productInCart2 = new ProductInCart(2L, productDTO2,1);

        cartService.add(productInCart1);
        cartService.add(productInCart2);

        Collection<ProductInCart> products = cartService.getAllProducts();

        assertEquals(2, products.size());
    }

    @Test
    void testRemoveProductFromCart() {
        Brand brand1 = new Brand(1L,"Chanel");
        Brand brand2 = new Brand(2L,"Dior");
        ProductDTO productDTO1 = new ProductDTO(new Product(1L,"Product 1", 10, "Red", "image1.jpg",brand1));
        ProductDTO productDTO2 = new ProductDTO(new Product(2L,"Product 2", 20, "Blue", "image2.jpg",brand2));

        ProductInCart productInCart1 = new ProductInCart(1L, productDTO1,1);
        ProductInCart productInCart2 = new ProductInCart(2L, productDTO2,1);

        cartService.add(productInCart1);
        cartService.add(productInCart2);

        cartService.remove(1L);

        Collection<ProductInCart> products = cartService.getAllProducts();

        assertEquals(1, products.size());
        assertNull(cartService.getAllProductss().get(1L));
    }

    @Test
    void testClearCart() {
        Brand brand1 = new Brand(1L,"Chanel");
        Brand brand2 = new Brand(2L,"Dior");
        ProductDTO productDTO1 = new ProductDTO(new Product(1L,"Product 1", 10, "Red", "image1.jpg",brand1));
        ProductDTO productDTO2 = new ProductDTO(new Product(2L,"Product 2", 20, "Blue", "image2.jpg",brand2));

        ProductInCart productInCart1 = new ProductInCart(1L, productDTO1,1);
        ProductInCart productInCart2 = new ProductInCart(2L, productDTO2,1);

        cartService.add(productInCart1);
        cartService.add(productInCart2);

        cartService.clear();

        Collection<ProductInCart> products = cartService.getAllProducts();

        assertEquals(0, products.size());
    }

    @Test
    void testGetCount() {
        Brand brand1 = new Brand(1L,"Chanel");
        Brand brand2 = new Brand(2L,"Dior");
        ProductDTO productDTO1 = new ProductDTO(new Product(1L,"Product 1", 10, "Red", "image1.jpg",brand1));
        ProductDTO productDTO2 = new ProductDTO(new Product(2L,"Product 2", 20, "Blue", "image2.jpg",brand2));

        ProductInCart productInCart1 = new ProductInCart(1L, productDTO1,1);
        ProductInCart productInCart2 = new ProductInCart(2L, productDTO2,1);

        cartService.add(productInCart1);
        cartService.add(productInCart2);

        assertEquals(2, cartService.getCount());
    }

    @Test
    void testGetAmount() {
        Brand brand1 = new Brand(1L,"Chanel");
        Brand brand2 = new Brand(2L,"Dior");
        ProductDTO productDTO1 = new ProductDTO(new Product(1L,"Product 1", 10, "Red", "image1.jpg",brand1));
        ProductDTO productDTO2 = new ProductDTO(new Product(2L,"Product 2", 20, "Blue", "image2.jpg",brand2));

        ProductInCart productInCart1 = new ProductInCart(1L, productDTO1,1);
        ProductInCart productInCart2 = new ProductInCart(2L, productDTO2,1);

        cartService.add(productInCart1);
        cartService.add(productInCart2);

        assertEquals(30, cartService.getAmount());
    }
}