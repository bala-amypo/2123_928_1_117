package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/violations")
public class ViolationRecordController {

    private final ViolationRecordService service;

    public ViolationRecordController(ViolationRecordService service) {
        this.service = service;
    }

    // ✅ Log Violation
    @PostMapping
    public ViolationRecord log(@RequestBody ViolationRecord v) {
        return service.logViolation(v);
    }

    // ✅ Resolve Violation
    @PutMapping("/{id}/resolve")
    public ViolationRecord resolve(@PathVariable Long id) {
        return service.markResolved(id);
    }

    // ✅ Violations by User
    @GetMapping("/user/{userId}")
    public List<ViolationRecord> byUser(@PathVariable Long userId) {
        return service.getViolationsByUser(userId);
    }

    // ✅ Unresolved Violations
    @GetMapping("/unresolved")
    public List<ViolationRecord> unresolved() {
        return service.getUnresolvedViolations();
    }
}
