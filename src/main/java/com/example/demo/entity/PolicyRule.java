package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(
        name = "policy_rules",
        uniqueConstraints = @UniqueConstraint(columnNames = "ruleCode")
)
public class PolicyRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ruleCode;

    private String description;

    private String severity; // LOW / MEDIUM / HIGH / CRITICAL

    @Column(columnDefinition = "TEXT")
    private String conditionsJson;

    private Boolean active;

    public PolicyRule() {}

    @PrePersist
    public void onCreate() {
        if (active == null) {
            active = true;
        }
    }

    // -------- Getters & Setters --------

    public Long getId() {
        return id;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public String getDescription() {
        return description;
    }

    public String getSeverity() {
        return severity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getConditionsJson() {
        return conditionsJson;
    }

    public void setConditionsJson(String conditionsJson) {
        this.conditionsJson = conditionsJson;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
