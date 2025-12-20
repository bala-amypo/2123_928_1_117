package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.LoginEvent.LoginStatus;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    private final LoginEventRepository repository;

    public LoginEventServiceImpl(LoginEventRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LoginEvent> getEventsByStatus(LoginStatus status) {
        return repository.findByStatus(status);
    }
}
