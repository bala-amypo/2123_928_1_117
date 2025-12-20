package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class LoginEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private LoginStatus status;

    private String deviceid;
    private String location;

    
    public enum LoginStatus {
        SUCCESS,
        FAILURE,
        BLOCKED
    }
}
