package com.example.demo.service.impl;

import com.example.demo.util.RuleEvaluationUtil;
import org.springframework.stereotype.Service;

@Service
public class LoginEventServiceImpl {

    private final RuleEvaluationUtil ruleEvaluationUtil;

    public LoginEventServiceImpl(RuleEvaluationUtil ruleEvaluationUtil) {
        this.ruleEvaluationUtil = ruleEvaluationUtil;
    }

    public void processLogin(String username) {
        boolean allowed = ruleEvaluationUtil.evaluateLoginRules(username);
        System.out.println("Login allowed: " + allowed);
    }
}
