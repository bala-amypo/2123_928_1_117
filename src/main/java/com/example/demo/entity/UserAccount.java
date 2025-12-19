package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_accounts",
       uniqueConstraints = {
            @UniqueConstraint(columnNames = "employeeid"),
            @UniqueConstraint(columnNames = "username"),
            @UniqueConstraint(columnNames = "email")
       })
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String employeeid;
    private String username;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;

    private LocalDateTime createdAt = LocalDateTime.now();

    public enum Role {
        ADMIN, USER, AUDITOR
    }

    public enum Status {
        ACTIVE, SUSPENDED
    }

    public UserAccount() {}

    // Getters & Setters
    // ...
}
