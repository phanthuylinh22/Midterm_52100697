package org.example.midterm.controller;

import org.example.midterm.DTO.ProductDTO;
import org.example.midterm.model.Product;
import org.example.midterm.model.ProductInCart;
import org.example.midterm.model.User;
import org.example.midterm.service.BrandService;
import org.example.midterm.service.CartService;
import org.example.midterm.service.ProductService;
import org.example.midterm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    private ProductService productService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private UserService userService;
    @Autowired
    private CartService cartService;

    @GetMapping("/cart")
    public  String showCart(Model model, @AuthenticationPrincipal UserDetails userDetails){
        if(userDetails != null){
            User user = userService.findByEmail(userDetails.getUsername());
            model.addAttribute("user", user);
        }
        model.addAttribute("cart_products", cartService.getAllProducts());
        model.addAttribute("quantity_cart", cartService.getCount());
        model.addAttribute("total", cartService.getAmount());
        return "cart";
    }
    @GetMapping("/cart/add/{id}")
    public String addCart(@PathVariable("id") Long id) {
        Product foundProduct = productService.findById(id);

        ProductInCart newCartProduct = new ProductInCart();
        newCartProduct.setProductId(foundProduct.getId());
        newCartProduct.setProductDTO(new ProductDTO(foundProduct));
        cartService.add(newCartProduct);

        return "redirect:/cart";
    }

    @GetMapping("/cart/minus/{id}")
    public String minusCart(@PathVariable("id") Long id) {
        Product foundProduct = productService.findById(id);

        ProductInCart newCartProduct = new ProductInCart();
        newCartProduct.setProductId(foundProduct.getId());
        newCartProduct.setProductDTO(new ProductDTO(foundProduct));
        cartService.minus(newCartProduct);

        return "redirect:/cart";
    }

    @GetMapping("/cart/remove/{id}")
    public String removeCart(@PathVariable("id") Long id) {
        cartService.remove(id);

        return "redirect:/cart";
    }

    @GetMapping("checkout")
    public String showFormCheckOut(Model model) {
        // Sao chép dữ liệu từ maps vào danh sách tạm thời
        List<ProductInCart> tempList = new ArrayList<>(cartService.getAllProducts());

        // Lấy tổng số lượng và tổng số tiền
        int count = cartService.getCount();
        Long amount = cartService.getAmount();

        // Xóa dữ liệu từ maps
        cartService.clear();

        // Đưa dữ liệu từ danh sách tạm thời vào model
        model.addAttribute("cart_products", tempList);
        model.addAttribute("quantity_cart", count);
        model.addAttribute("total", amount);

        return "checkout";
    }


}
