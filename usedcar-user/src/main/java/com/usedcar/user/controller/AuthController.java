package com.usedcar.user.controller;

import com.usedcar.user.entity.User;
import com.usedcar.user.service.UserService;
import com.usedcar.user.util.JwtUtil;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    // 注册
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        if (userService.getByUsername(request.getUsername()) != null) {
            return "用户名已存在";
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // 密码加密存储
        userService.save(user);
        return "注册成功";
    }

    // 登录，成功返回token
    @PostMapping("/login")
    public Object login(@RequestBody LoginRequest request) {
        User user = userService.getByUsername(request.getUsername());
        if (user == null || !passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return "用户名或密码错误";
        }
        String token = jwtUtil.generateToken(user.getUsername());
        return new LoginResponse(token);
    }

    @Data
    static class RegisterRequest {
        private String username;
        private String password;
    }

    @Data
    static class LoginRequest {
        private String username;
        private String password;
    }

    @Data
    static class LoginResponse {
        private String token;
        public LoginResponse(String token) {
            this.token = token;
        }
    }
}
