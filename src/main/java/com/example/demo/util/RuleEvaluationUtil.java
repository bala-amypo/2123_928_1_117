// package com.example.demo.util;

// import com.example.demo.entity.LoginEvent;
// import com.example.demo.entity.ViolationRecord;
// import com.example.demo.entity.PolicyRule;
// import com.example.demo.repository.PolicyRuleRepository;
// import com.example.demo.repository.ViolationRecordRepository;
// import org.springframework.stereotype.Component;

// import java.time.LocalDateTime;
// import java.util.List;

// @Component
// public class RuleEvaluationUtil {

//     private final PolicyRuleRepository ruleRepo;
//     private final ViolationRecordRepository violationRepo;

//     public RuleEvaluationUtil(PolicyRuleRepository ruleRepo, ViolationRecordRepository violationRepo) {
//         this.ruleRepo = ruleRepo;
//         this.violationRepo = violationRepo;
//     }

//     public void evaluateLoginEvent(LoginEvent event) {
//         List<PolicyRule> activeRules = ruleRepo.findByActiveTrue();

//         for (PolicyRule rule : activeRules) {
//             // Example evaluation: simple match by loginStatus string in conditionsJson
//             if (rule.getConditionsJson().contains(event.getLoginStatus())) {
//                 ViolationRecord v = new ViolationRecord();
//                 v.setUserId(event.getUserId());
//                 v.setEventId(event.getId());
//                 v.setPolicyRuleId(rule.getId());
//                 v.setSeverity(rule.getSeverity());
//                 v.setDetails("Violation triggered for rule " + rule.getRuleCode());
//                 v.setDetectedAt(LocalDateTime.now());
//                 v.setResolved(false);

//                 violationRepo.save(v);
//             }
//         }
//     }
// }


// // package com.example.demo.util;

// // import com.example.demo.entity.*;
// // import com.example.demo.repository.*;

// // import java.time.LocalDateTime;
// // import java.util.List;


// // import org.springframework.stereotype.Component;

// // @Component
// // public class RuleEvaluationUtil {

// //     private final PolicyRuleRepository ruleRepo;
// //     private final ViolationRecordRepository violationRepo;

// //     public RuleEvaluationUtil(PolicyRuleRepository ruleRepo,
// //                               ViolationRecordRepository violationRepo) {
// //         this.ruleRepo = ruleRepo;
// //         this.violationRepo = violationRepo;
// //     }

// //     public void evaluateLoginEvent(LoginEvent event) {
// //         List<PolicyRule> rules = ruleRepo.findByActiveTrue();

// //         for (PolicyRule rule : rules) {
// //             if (rule.getConditionsJson() != null &&
// //                 event.getLoginStatus() != null &&
// //                 rule.getConditionsJson().contains(event.getLoginStatus())) {

// //                 ViolationRecord v = new ViolationRecord();
// //                 v.setSeverity(rule.getSeverity());
// //                 v.setDetectedAt(LocalDateTime.now());
// //                 v.setResolved(false);

// //                 violationRepo.save(v);
// //             }
// //         }
// //     }
// // }

package com.example.demo.util;

import com.example.demo.entity.*;
import com.example.demo.repository.*;

public class RuleEvaluationUtil {
    private final PolicyRuleRepository ruleRepo;
    private final ViolationRecordRepository violationRepo;

    public RuleEvaluationUtil(PolicyRuleRepository ruleRepo,
                              ViolationRecordRepository violationRepo) {
        this.ruleRepo = ruleRepo;
        this.violationRepo = violationRepo;
    }

    public void evaluateLoginEvent(LoginEvent e) {
        for (PolicyRule r : ruleRepo.findByActiveTrue()) {
            if (r.getConditionsJson() != null &&
                e.getLoginStatus() != null &&
                r.getConditionsJson().contains(e.getLoginStatus())) {

                ViolationRecord v = new ViolationRecord();
                v.setSeverity(r.getSeverity());
                violationRepo.save(v);
            }
        }
    }
}
