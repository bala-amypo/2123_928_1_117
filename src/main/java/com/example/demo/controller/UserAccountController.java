package com.example.demo.controller;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    private final UserAccountService service;

    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    // ------------------ Create new user ------------------
    @PostMapping
    public ResponseEntity<UserAccount> createUser(@RequestBody UserAccount user) {
        UserAccount created = service.createUser(user);
        return ResponseEntity.ok(created);
    }

    // ------------------ Get user by ID ------------------
    @GetMapping("/{id}")
    public ResponseEntity<UserAccount> getUserById(@PathVariable Long id) {
        UserAccount user = service.getUserById(id);
        return ResponseEntity.ok(user);
    }

    // ------------------ Update account status ------------------
    @PutMapping("/{id}/status")
    public ResponseEntity<UserAccount> updateStatus(@PathVariable Long id, @RequestParam String status) {
        UserAccount updated = service.updateUserStatus(id, status);
        return ResponseEntity.ok(updated);
    }

    // ------------------ Get user by username ------------------
    // @GetMapping("/username/{username}")
    // public ResponseEntity<UserAccount> getByUsername(@PathVariable String username) {
    //     UserAccount user = service.findByUsername(username).orElseThrow(
    // () -> new RuntimeException("User not found")
    //     );
    //     return ResponseEntity.ok(user);
    // }

    // ------------------ List all users ------------------
    @GetMapping
    public ResponseEntity<List<UserAccount>> getAllUsers() {
        List<UserAccount> users = service.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
