package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "device_profiles", uniqueConstraints = @UniqueConstraint(columnNames = {"userId", "deviceId"}))
public class DeviceProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String deviceId;

    private String deviceType;

    private String osVersion;

    private Boolean isTrusted = false;

    private LocalDateTime lastSeen;

    // ------------------ Constructors ------------------
    public DeviceProfile() {}

    public DeviceProfile(Long userId, String deviceId, String deviceType, String osVersion, Boolean isTrusted) {
        this.userId = userId;
        this.deviceId = deviceId;
        this.deviceType = deviceType;
        this.osVersion = osVersion;
        this.isTrusted = isTrusted;
    }

    // ------------------ Getters & Setters ------------------
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getDeviceId() { return deviceId; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }

    public String getDeviceType() { return deviceType; }
    public void setDeviceType(String deviceType) { this.deviceType = deviceType; }

    public String getOsVersion() { return osVersion; }
    public void setOsVersion(String osVersion) { this.osVersion = osVersion; }

    public Boolean getIsTrusted() { return isTrusted; }
    public void setIsTrusted(Boolean isTrusted) { this.isTrusted = isTrusted; }

    public LocalDateTime getLastSeen() { return lastSeen; }
    public void setLastSeen(LocalDateTime lastSeen) { this.lastSeen = lastSeen; }
}
