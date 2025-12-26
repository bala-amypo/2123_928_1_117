package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService service;

    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    // ✅ Register User (Swagger shows ONLY JSON body)
    @PostMapping("/register")
    public UserAccount register(@RequestBody UserAccount user) {
        return service.register(user);
    }

    // ✅ Get User by ID
    @GetMapping("/{id}")
    public UserAccount getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // ✅ Get User by Username
    @GetMapping("/username/{username}")
    public UserAccount getByUsername(@PathVariable String username) {
        return service.getByUsername(username);
    }

    // ✅ Get All Users
    @GetMapping
    public List<UserAccount> getAll() {
        return service.getAllUsers();
    }

    // ✅ Deactivate User
    @PutMapping("/deactivate/{id}")
    public UserAccount deactivate(@PathVariable Long id) {
        return service.deactivateUser(id);
    }
}
