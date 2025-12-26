package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String employeeId;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String role;
    private String status;

    private LocalDateTime createdAt;

    public UserAccount() {
    }

    // All setters/getters
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    public void setUsername(String username) { this.username = username; }
    public String getUsername() { return username; }

    public void setEmail(String email) { this.email = email; }
    public String getEmail() { return email; }

    public void setPassword(String password) { this.password = password; }
    public String getPassword() { return password; }

    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public String getEmployeeId() { return employeeId; }

    public void setRole(String role) { this.role = role; }
    public String getRole() { return role; }

    public void setStatus(String status) { this.status = status; }
    public String getStatus() { return status; }
}
