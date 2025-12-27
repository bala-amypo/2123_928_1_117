package com.example.demo.util;

import org.springframework.stereotype.Component;

@Component
public class RuleEvaluationUtil {
z
    public boolean evaluateLoginRules(String username) {
        // dummy logic (replace with real rule logic)
        return username != null && !username.isEmpty();
    }
}
