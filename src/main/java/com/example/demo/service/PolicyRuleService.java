package com.example.demo.service;

import com.example.demo.entity.PolicyRule;
import java.util.List;

public interface PolicyRuleService {

    PolicyRule save(PolicyRule rule);

    List<PolicyRule> getActiveRules();

    PolicyRule getByRuleCode(String ruleCode);
}