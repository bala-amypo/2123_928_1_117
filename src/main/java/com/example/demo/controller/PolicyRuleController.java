package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policy-rules")
public class PolicyRuleController {

    @Autowired
    private PolicyRuleService ruleService;

    @PostMapping
    public PolicyRule save(@RequestBody PolicyRule rule) {
        return ruleService.save(rule);
    }

    @GetMapping("/active")
    public List<PolicyRule> getActiveRules() {
        return ruleService.getActiveRules();
    }

    @GetMapping("/{ruleCode}")
    public PolicyRule getRuleByCode(@PathVariable String ruleCode) {
        return ruleService.getByRuleCode(ruleCode);
    }
}