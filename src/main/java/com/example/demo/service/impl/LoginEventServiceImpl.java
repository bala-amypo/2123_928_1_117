package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.LoginEvent;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository loginEventRepository;

    public LoginEventServiceImpl(LoginEventRepository loginEventRepository) {
        this.loginEventRepository = loginEventRepository;
    }

    @Override
    public LoginEvent save(LoginEvent loginEvent) {
        return loginEventRepository.save(loginEvent);
    }

    @Override
    public List<LoginEvent> getUserLoginEvents(Long userId) {
        return loginEventRepository.findByUserId(userId);
    }

    @Override
    public List<LoginEvent> getUserFailedLogins(Long userId) {
        return loginEventRepository.findByUserIdAndStatus(
                userId, LoginEvent.LoginStatus.FAILED);
    }
}
