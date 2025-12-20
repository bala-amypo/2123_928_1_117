package com.example.demo.service;

import com.example.demo.entity.LoginEvent;
import com.example.demo.entity.LoginEvent.LoginStatus;

import java.util.List;

public interface LoginEventService {

    List<LoginEvent> getEventsByStatus(LoginStatus status);
}
