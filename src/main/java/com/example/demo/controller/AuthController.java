package com.example.demo.controller;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserAccount;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private UserAccountService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public UserAccount register(@RequestBody RegisterRequest req) {
        UserAccount user = new UserAccount();
        user.setEmployeeid(req.getEmployeeid());
        user.setUsername(req.getUsername());
        user.setEmail(req.getEmail());
        user.setPassword(passwordEncoder.encode(req.getPassword()));
        user.setRole(UserAccount.Role.valueOf(req.getRole()));

        return userService.register(user);
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest request) {

        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword());

        authManager.authenticate(token);

        UserAccount user = userService.findByUsername(request.getUsername());

        String jwt = jwtUtil.generateToken(user.getUsername(), user.getRole().name());

        return new JwtResponse(jwt, user.getUsername(), user.getRole().name());
    }
}