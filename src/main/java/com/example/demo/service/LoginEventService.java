package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.LoginEvent;

public interface LoginEventService {

    LoginEvent save(LoginEvent loginEvent);

    List<LoginEvent> getUserLoginEvents(Long userId);

    List<LoginEvent> getUserFailedLogins(Long userId);
}
