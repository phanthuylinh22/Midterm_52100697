package org.example.midterm.api;

import jakarta.validation.Valid;
import org.example.midterm.DTO.UserDTO;
import org.example.midterm.model.User;
import org.example.midterm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthAPI {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> registration(@Valid @RequestBody UserDTO user,
                                          BindingResult result) {
        User existing = userService.findByEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }
        userService.saveUser(user);
        return ResponseEntity.ok().body("Registration successful");
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserDTO loginUser) {
        // Tìm kiếm người dùng trong cơ sở dữ liệu dựa trên email
        User existingUser = userService.findByEmail(loginUser.getEmail());

        if (existingUser == null) {
            return ResponseEntity.badRequest().body("Invalid email or password");
        }

        // So sánh mật khẩu đã mã hóa
        if (!passwordEncoder.matches(loginUser.getPassword(), existingUser.getPassword())) {
            return ResponseEntity.badRequest().body("Invalid email or password");
        }

        // Đăng nhập thành công, trả về thông tin người dùng
        return ResponseEntity.ok("Login success");
    }
}