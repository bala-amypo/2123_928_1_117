package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
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
    private Boolean resolved;
    private LocalDateTime detectedAt;

    public ViolationRecord() { }

    // All setters/getters
    public void setDetectedAt(LocalDateTime detectedAt) { this.detectedAt = detectedAt; }
    public LocalDateTime getDetectedAt() { return detectedAt; }

    public void setResolved(Boolean resolved) { this.resolved = resolved; }
    public Boolean getResolved() { return resolved; }

    public void setUserId(Long userId) { this.userId = userId; }
    public Long getUserId() { return userId; }

    public void setPolicyRuleId(Long policyRuleId) { this.policyRuleId = policyRuleId; }
    public Long getPolicyRuleId() { return policyRuleId; }

    public void setEventId(Long eventId) { this.eventId = eventId; }
    public Long getEventId() { return eventId; }

    public void setViolationType(String violationType) { this.violationType = violationType; }
    public String getViolationType() { return violationType; }

    public void setDetails(String details) { this.details = details; }
    public String getDetails() { return details; }

    public void setSeverity(String severity) { this.severity = severity; }
    public String getSeverity() { return severity; }
}
