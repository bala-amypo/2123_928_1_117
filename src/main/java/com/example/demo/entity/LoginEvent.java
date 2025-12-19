package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "login_events")
public class LoginEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userid;
    private String ipAddress;
    private String location;
    private String deviceid;

    private LocalDateTime timestamp = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private LoginStatus loginStatus;

    public enum LoginStatus {
        SUCCESS, FAILED
    }

    public LoginEvent() {}

    // Getters & Setters
    // ...
}
