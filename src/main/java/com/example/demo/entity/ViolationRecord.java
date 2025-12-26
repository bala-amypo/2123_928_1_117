package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "violation_records")
public class ViolationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long policyRuleId;
    private Long eventId;

    private String violationType;
    private String details;
    private String severity;

    private LocalDateTime detectedAt;
    private Boolean resolved;

    public ViolationRecord() {}

    @PrePersist
    public void onCreate() {
        detectedAt = LocalDateTime.now();
        if (resolved == null) {
            resolved = false;
        }
    }

    // -------- Getters & Setters --------

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getPolicyRuleId() {
        return policyRuleId;
    }

    public Long getEventId() {
        return eventId;
    }

    public String getViolationType() {
        return violationType;
    }

    public String getDetails() {
        return details;
    }

    public String getSeverity() {
        return severity;
    }

    public LocalDateTime getDetectedAt() {
        return detectedAt;
    }

    public Boolean getResolved() {
        return resolved;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setPolicyRuleId(Long policyRuleId) {
        this.policyRuleId = policyRuleId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public void setViolationType(String violationType) {
        this.violationType = violationType;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }
}
