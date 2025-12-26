package com.example.demo.controller;

import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyRuleController {

    private final PolicyRuleService service;

    public PolicyRuleController(PolicyRuleService service) {
        this.service = service;
    }

    // ✅ Create Rule
    @PostMapping
    public PolicyRule create(@RequestBody PolicyRule rule) {
        return service.createRule(rule);
    }

    // ✅ Update Rule
    @PutMapping("/{id}")
    public PolicyRule update(@PathVariable Long id,
                             @RequestBody PolicyRule rule) {
        return service.updateRule(id, rule);
    }

    // ✅ Active Rules
    @GetMapping("/active")
    public List<PolicyRule> active() {
        return service.getActiveRules();
    }

    // ✅ All Rules
    @GetMapping
    public List<PolicyRule> all() {
        return service.getAllRules();
    }
}
