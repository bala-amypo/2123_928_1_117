package com.example.demo.service.impl;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.LoginEvent.LoginStatus;
import com.example.demo.repository.LoginEventRepository;
import com.example.demo.service.LoginEventService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class LoginEventServiceImpl implements LoginEventService {

    @Autowired
    private LoginEventRepository loginRepo;

    @Override
    public LoginEvent save(LoginEvent event) {
        return loginRepo.save(event);
    }

    @Override
    public List<LoginEvent> getUserLoginEvents(Long userid) {
        return loginRepo.findByUserid(userid);
    }

    @Override
    public List<LoginEvent> getUserFailedLogins(Long userid) {
        return loginRepo.findByUseridAndLoginStatus(userid, LoginStatus.FAILED);
    }
}