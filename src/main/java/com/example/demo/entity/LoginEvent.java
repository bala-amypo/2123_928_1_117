package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class LoginEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @Enumerated(EnumType.STRING)
    private LoginStatus status;

    public enum LoginStatus {
        SUCCESS,
        FAILED
    }

    // getters & setters
}
