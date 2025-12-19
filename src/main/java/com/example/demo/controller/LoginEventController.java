package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/login-events")
public class LoginEventController {

    @Autowired
    private LoginEventService loginService;

    @PostMapping
    public LoginEvent save(@RequestBody LoginEvent event) {
        return loginService.save(event);
    }

    @GetMapping("/user/{userid}")
    public List<LoginEvent> getUserEvents(@PathVariable Long userid) {
        return loginService.getUserLoginEvents(userid);
    }

    @GetMapping("/user/{userid}/failed")
    public List<LoginEvent> getUserFailedEvents(@PathVariable Long userid) {
        return loginService.getUserFailedLogins(userid);
    }
}