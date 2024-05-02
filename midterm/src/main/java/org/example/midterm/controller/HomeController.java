package org.example.midterm.controller;


import org.example.midterm.DTO.ProductDTO;
import org.example.midterm.model.Brand;
import org.example.midterm.model.Product;
import org.example.midterm.model.ProductInCart;
import org.example.midterm.model.User;
import org.example.midterm.service.BrandService;
import org.example.midterm.service.CartService;
import org.example.midterm.service.ProductService;
import org.example.midterm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ProductService productService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private UserService userService;
    @Autowired
    private CartService cartService;

    @GetMapping("/test")
    public String test(@AuthenticationPrincipal UserDetails userDetails,@RequestParam(required = false) String keyword,
                       @RequestParam(required = false) Long brandId,Model model){
        List<Product> products;
        List<Brand> brands = brandService.getAll();
        if (keyword != null && !keyword.isEmpty()) {
            products = productService.searchByName(keyword);
            model.addAttribute("search_word", keyword);
        } else if (brandId != null) {
            products = brandService.findById(brandId);
        } else {
            products = productService.getAll();
        }
        model.addAttribute("products", products);
        model.addAttribute("brands", brands);
        model.addAttribute("quantity_cart", cartService.getCount());
        if(userDetails!=null){
            User user = userService.findByEmail(userDetails.getUsername());
            model.addAttribute("user", user);
        }
        return "products";
    }


    @GetMapping("/")
    public String showIndex(Model model, @AuthenticationPrincipal UserDetails userDetails,
                            @RequestParam(required = false) String keyword,
                            @RequestParam(required = false) Long brandId) {
        List<Product> products;
        List<Brand> brands = brandService.getAll();
        if (keyword != null && !keyword.isEmpty()) {
            products = productService.searchByName(keyword);
            model.addAttribute("search_word", keyword);
        } else if (brandId != null) {
            products = brandService.findById(brandId);
        } else {
            products = productService.getAll();
        }
        model.addAttribute("products", products);
        model.addAttribute("brands", brands);
        model.addAttribute("quantity_cart", cartService.getCount());
        if(userDetails!=null){
            User user = userService.findByEmail(userDetails.getUsername());
            model.addAttribute("user", user);
        }
        return "products";
    }


}


