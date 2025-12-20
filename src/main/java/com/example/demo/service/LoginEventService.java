package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;

@Service
public class LoginEventService {

    private final LoginEventRepository loginEventRepository;

    public LoginEventService(LoginEventRepository loginEventRepository) {
        this.loginEventRepository = loginEventRepository;
    }

    public LoginEvent save(LoginEvent loginEvent) {
        return loginEventRepository.save(loginEvent);
    }

    public List<LoginEvent> getUserLoginEvents(Long userId) {
        return loginEventRepository.findByUserId(userId);
    }

    public List<LoginEvent> getUserFailedLogins(Long userId) {
        return loginEventRepository.findByUserIdAndStatus(
                userId,
                LoginEvent.LoginStatus.FAILED
        );
    }
}
