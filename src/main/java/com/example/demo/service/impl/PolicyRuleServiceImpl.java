package com.example.demo.service.impl;

import com.example.demo.entity.PolicyRule;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PolicyRuleRepository;
import com.example.demo.service.PolicyRuleService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PolicyRuleServiceImpl implements PolicyRuleService {

    private final PolicyRuleRepository repo;

    public PolicyRuleServiceImpl(PolicyRuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public PolicyRule createRule(PolicyRule rule) {
        if (repo.findByRuleCode(rule.getRuleCode()).isPresent()) {
            throw new BadRequestException("Rule code must be unique");
        }
        return repo.save(rule);
    }

    @Override
    public PolicyRule updateRule(Long id, PolicyRule updated) {
        PolicyRule rule = repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Rule not found"));

        rule.setDescription(updated.getDescription());
        rule.setSeverity(updated.getSeverity());
        rule.setConditionsJson(updated.getConditionsJson());
        rule.setActive(updated.getActive());
        return repo.save(rule);
    }

    @Override
    public List<PolicyRule> getActiveRules() {
        return repo.findByActiveTrue();
    }

    @Override
    public Optional<PolicyRule> getRuleByCode(String code) {
        return repo.findByRuleCode(code);
    }

    @Override
    public List<PolicyRule> getAllRules() {
        return repo.findAll();
    }
}
