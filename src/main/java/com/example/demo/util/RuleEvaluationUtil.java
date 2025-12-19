package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.PolicyRule;

import org.springframework.stereotype.Component;

@Component
public class RuleEvaluationUtil {

    public boolean evaluateRule(PolicyRule rule, LoginEvent event) {

        // Example rules:
        switch (rule.getRuleCode()) {

            case "FAILED_LOGIN_LIMIT":
                return event.getStatus().equalsIgnoreCase("FAILED");

            case "NEW_DEVICE_DETECTED":
                return event.getDeviceid() != null;

            case "UNUSUAL_LOCATION":
                return event.getLocation() != null
                        && !event.getLocation().equalsIgnoreCase("CompanyHQ");

            default:
                return false;
        }
    }
}