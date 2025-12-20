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

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public LoginStatus getStatus() {
        return status;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setStatus(LoginStatus status) {
        this.status = status;
    }
}
