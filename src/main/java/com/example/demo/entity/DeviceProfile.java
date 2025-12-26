package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class DeviceProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @Column(nullable = false)
    private String deviceId;

    private String deviceType;
    private String osVersion;
    private Boolean isTrusted;
    private LocalDateTime lastSeen;

    public DeviceProfile() { }

    // All setters/getters
    public void setLastSeen(LocalDateTime lastSeen) { this.lastSeen = lastSeen; }
    public LocalDateTime getLastSeen() { return lastSeen; }

    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }
    public String getDeviceId() { return deviceId; }

    public void setIsTrusted(Boolean trusted) { this.isTrusted = trusted; }
    public Boolean getIsTrusted() { return isTrusted; }

    public void setUserId(Long userId) { this.userId = userId; }
    public Long getUserId() { return userId; }
}
