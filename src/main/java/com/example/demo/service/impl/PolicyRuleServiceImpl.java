package com.example.demo.service.impl;

import com.example.demo.entity.PolicyRule;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.PolicyRuleService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {

    @Autowired
    private PolicyRuleRepository ruleRepo;

    @Override
    public PolicyRule save(PolicyRule rule) {
        return ruleRepo.save(rule);
    }

    @Override
    public List<PolicyRule> getActiveRules() {
        return ruleRepo.findByActiveTrue();
    }

    @Override
    public PolicyRule getByRuleCode(String ruleCode) {
        return ruleRepo.findByRuleCode(ruleCode)
                .orElseThrow(() -> new ResourceNotFoundException("Rule not found: " + ruleCode));
    }
}