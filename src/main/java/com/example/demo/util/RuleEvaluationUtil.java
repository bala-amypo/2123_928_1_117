package com.example.demo.util;

import java.util.List;

import com.example.demo.entity.LoginEvent;

public class RuleEvaluationUtil {

    private RuleEvaluationUtil() {
        // Utility class – prevent object creation
    }

    /**
     * Rule:
     * If a user has 3 or more FAILED login attempts, flag as suspicious
     */
    public static boolean isUserSuspicious(List<LoginEvent> loginEvents) {

        long failedCount = loginEvents.stream()
                .filter(event -> event.getStatus() == LoginEvent.LoginStatus.FAILED)
                .count();

        return failedCount >= 3;
    }

    /**
     * Rule:
     * Check if last login attempt was FAILED
     */
    public static boolean isLastLoginFailed(List<LoginEvent> loginEvents) {

        if (loginEvents == null || loginEvents.isEmpty()) {
            return false;
        }

        LoginEvent lastEvent = loginEvents.get(loginEvents.size() - 1);

        return lastEvent.getStatus() == LoginEvent.LoginStatus.FAILED;
    }

    /**
     * Rule:
     * Count number of failed login attempts
     */
    public static long countFailedLogins(List<LoginEvent> loginEvents) {

        return loginEvents.stream()
                .filter(event -> event.getStatus() == LoginEvent.LoginStatus.FAILED)
                .count();
    }
}
