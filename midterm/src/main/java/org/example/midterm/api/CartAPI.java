package org.example.midterm.api;

import org.example.midterm.DTO.CheckoutResponse;
import org.example.midterm.DTO.ProductDTO;
import org.example.midterm.model.Product;
import org.example.midterm.model.ProductInCart;
import org.example.midterm.service.CartService;
import org.example.midterm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/cart")
public class CartAPI {
    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;
    @GetMapping("")
    @ResponseBody
    public ResponseEntity<?> showCart() {
        Map<String, Object> response = new HashMap<>();
        response.put("cart_products", cartService.getAllProducts());
        response.put("quantity_cart", cartService.getCount());
        response.put("total", cartService.getAmount());
        return ResponseEntity.ok().body(response);
    }
    @PostMapping("/add/{id}")
    public ResponseEntity<String> addProductToCart(@PathVariable("id") Long id) {
        Product foundProduct = productService.findById(id);

        if (foundProduct == null) {
            return ResponseEntity.notFound().build();
        }

        ProductInCart newCartProduct = new ProductInCart();
        newCartProduct.setProductId(foundProduct.getId());
        newCartProduct.setProductDTO(new ProductDTO(foundProduct));
        cartService.add(newCartProduct);

        return ResponseEntity.ok().body("Product added to cart successfully");
    }

    @PutMapping("/minus/{id}")
    public ResponseEntity<String> minusProductFromCart(@PathVariable("id") Long id) {
        Product foundProduct = productService.findById(id);

        if (foundProduct == null) {
            return ResponseEntity.notFound().build();
        }

        ProductInCart cartProduct = new ProductInCart();
        cartProduct.setProductId(foundProduct.getId());
        cartProduct.setProductDTO(new ProductDTO(foundProduct));

        cartService.minus(cartProduct);

        return ResponseEntity.ok().body("Product quantity decreased successfully");
    }
    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeProductFromCart(@PathVariable("id") Long id) {
        cartService.remove(id);
        return ResponseEntity.ok().body("Product removed from cart successfully");
    }
    @GetMapping("/checkout")
    public ResponseEntity<CheckoutResponse> checkout() {
        // Sao chép dữ liệu từ maps vào danh sách tạm thời
        List<ProductInCart> tempList = new ArrayList<>(cartService.getAllProducts());

        // Lấy tổng số lượng và tổng số tiền
        int count = cartService.getCount();
        Long amount = cartService.getAmount();

        // Xóa dữ liệu từ maps
        cartService.clear();

        // Xử lý thanh toán ở đây
        // Ví dụ: Gọi các dịch vụ thanh toán, xác nhận đơn hàng, cập nhật cơ sở dữ liệu, v.v.

        // Tạo đối tượng CheckoutResponse và trả về
        CheckoutResponse response = new CheckoutResponse(tempList, count, amount);
        return ResponseEntity.ok().body(response);
    }


}
