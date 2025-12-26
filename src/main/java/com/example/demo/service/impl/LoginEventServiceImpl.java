package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.exception.BadRequestException;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import com.example.demo.util.RuleEvaluationUtil;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository repo;
    private final RuleEvaluationUtil evaluator;

    public LoginEventServiceImpl(LoginEventRepository repo,
                                 RuleEvaluationUtil evaluator) {
        this.repo = repo;
        this.evaluator = evaluator;
    }

    @Override
    public LoginEvent recordLogin(LoginEvent event) {

        if (event.getIpAddress() == null)
            throw new BadRequestException("IP address is required");

        if (event.getDeviceId() == null)
            throw new BadRequestException("Device ID is required");

        LoginEvent saved = repo.save(event);
        evaluator.evaluateLoginEvent(saved);
        return saved;
    }

    @Override
    public List<LoginEvent> getEventsByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public List<LoginEvent> getSuspiciousLogins(Long userId) {
        return repo.findByUserIdAndLoginStatus(userId, "FAILED");
    }

    @Override
    public List<LoginEvent> getAllEvents() {
        return repo.findAll();
    }
}
