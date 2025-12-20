package com.example.demo.service;

import com.example.demo.entity.PolicyRule;
import com.example.demo.repository.PolicyRuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyRuleServiceImpl implements PolicyRuleService {

    @Autowired
    private PolicyRuleRepository ruleRepo;

    @Override
    public List<PolicyRule> getAllActiveRules() {
        return ruleRepo.findByActiveTrue();
    }

    @Override
    public Optional<PolicyRule> getRuleByCode(String code) {
        return ruleRepo.findByRuleCode(code);
    }

    @Override
    public PolicyRule saveRule(PolicyRule rule) {
        return ruleRepo.save(rule);
    }
}
