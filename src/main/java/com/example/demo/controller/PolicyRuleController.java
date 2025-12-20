package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/policy")
public class PolicyRuleController {

    @Autowired
    private PolicyRuleService ruleService;

    @GetMapping("/active")
    public List<PolicyRule> getActiveRules() {
        return ruleService.getAllActiveRules();
    }

    @GetMapping("/{code}")
    public Optional<PolicyRule> getRuleByCode(@PathVariable String code) {
        return ruleService.getRuleByCode(code);
    }

    @PostMapping("/add")
    public PolicyRule addRule(@RequestBody PolicyRule rule) {
        return ruleService.saveRule(rule);
    }
}
