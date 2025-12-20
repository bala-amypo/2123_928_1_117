package com.example.demo.repository;

import com.example.demo.entity.PolicyRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PolicyRuleRepository extends JpaRepository<PolicyRule, Long> {

    // Query by the new field 'ruleCode'
    Optional<PolicyRule> findByRuleCode(String ruleCode);

    // Example: get all active rules
    List<PolicyRule> findByActiveTrue();
}
