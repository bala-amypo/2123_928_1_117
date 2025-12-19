package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "violation_records")
public class ViolationRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userid;
    private Long policyRuleId;
    private Long eventId;

    private String violationType;
    private String details;

    @Enumerated(EnumType.STRING)
    private Severity severity;

    private LocalDateTime detectedAt = LocalDateTime.now();
    private boolean resolved = false;

    public enum Severity {
        LOW, MEDIUM, HIGH, CRITICAL
    }

    public ViolationRecord() {}

    // Getters & Setters
    // ...
}
