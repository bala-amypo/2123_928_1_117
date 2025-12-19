package com.example.demo.service;

import com.example.demo.entity.LoginEvent;
import java.util.List;

public interface LoginEventService {

    LoginEvent save(LoginEvent event);

    List<LoginEvent> getUserLoginEvents(Long userid);

    List<LoginEvent> getUserFailedLogins(Long userid);
}