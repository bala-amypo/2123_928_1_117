package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "device_profiles",
       uniqueConstraints = @UniqueConstraint(columnNames = "deviceid"))
public class DeviceProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userid;
    private String deviceid;
    private String deviceType;
    private String osVersion;

    private LocalDateTime lastSeen = LocalDateTime.now();
    private boolean isTrusted;

    public DeviceProfile() {}

    // Getters & Setters
    // ...
}
