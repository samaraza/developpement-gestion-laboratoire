package com.example.gestionlabo.controller;

import com.example.gestionlabo.config.PasswordEncoderConfig;
import com.example.gestionlabo.model.User;
import com.example.gestionlabo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;




@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {

        return userService.registerUser(user);
    }
    @GetMapping("/login")
    public ResponseEntity<?> login() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userService.findByEmail(userDetails.getUsername());
        return ResponseEntity.ok(user);
    }
}
