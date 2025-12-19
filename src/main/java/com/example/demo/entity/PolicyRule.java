package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "policy_rules",
       uniqueConstraints = @UniqueConstraint(columnNames = "ruleCode"))
public class PolicyRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleCode;
    private String description;

    @Enumerated(EnumType.STRING)
    private Severity severity;

    private String conditionJson;
    private boolean active;

    public enum Severity {
        LOW, MEDIUM, HIGH, CRITICAL
    }

    public PolicyRule() {}

    // Getters & Setters
    // ...
}
