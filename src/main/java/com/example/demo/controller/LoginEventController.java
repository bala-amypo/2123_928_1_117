package com.example.demo.controller;

import com.example.demo.entity.LoginEvent;
import com.example.demo.service.LoginEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logins")
public class LoginEventController {

    private final LoginEventService service;

    public LoginEventController(LoginEventService service) {
        this.service = service;
    }

    // ✅ Record Login Event
    @PostMapping("/record")
    public LoginEvent record(@RequestBody LoginEvent event) {
        return service.recordLogin(event);
    }

    // ✅ Get Events by User
    @GetMapping("/user/{userId}")
    public List<LoginEvent> getByUser(@PathVariable Long userId) {
        return service.getEventsByUser(userId);
    }

    // ✅ Suspicious Logins
    @GetMapping("/suspicious/{userId}")
    public List<LoginEvent> suspicious(@PathVariable Long userId) {
        return service.getSuspiciousLogins(userId);
    }

    // ✅ All Login Events
    @GetMapping
    public List<LoginEvent> all() {
        return service.getAllEvents();
    }
}
