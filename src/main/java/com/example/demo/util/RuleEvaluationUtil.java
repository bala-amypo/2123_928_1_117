package com.example.demo.util;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.PolicyRule;
import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import com.example.demo.service.PolicyRuleService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class RuleEvaluationUtil {

    private final PolicyRuleService ruleService;
    private final ViolationRecordService violationService;

    public RuleEvaluationUtil(PolicyRuleService ruleService,
                              ViolationRecordService violationService) {
        this.ruleService = ruleService;
        this.violationService = violationService;
    }

    /**
     * Evaluate a login event against all active rules.
     * Logs a ViolationRecord if any rule is triggered.
     */
    public void evaluateLoginEvent(LoginEvent event) {

        List<PolicyRule> activeRules = ruleService.getActiveRules();

        for (PolicyRule rule : activeRules) {

            boolean violationDetected = false;

            // Example: You can customize evaluation logic per rule conditions
            String conditions = rule.getConditionsJson();

            if (conditions.contains("FAILED_LOGIN") && "FAILED".equals(event.getLoginStatus())) {
                violationDetected = true;
            }

            // Add more rule logic here as needed

            if (violationDetected) {
                ViolationRecord record = new ViolationRecord();
                record.setUserId(event.getUserId());
                record.setEventId(event.getId());
                record.setPolicyRuleId(rule.getId());
                record.setViolationType("LOGIN_VIOLATION");
                record.setSeverity(rule.getSeverity());
                record.setDetails("Login violation triggered by rule: " + rule.getRuleCode());
                record.setDetectedAt(LocalDateTime.now());
                record.setResolved(false);

                violationService.logViolation(record);
            }
        }
    }
}
