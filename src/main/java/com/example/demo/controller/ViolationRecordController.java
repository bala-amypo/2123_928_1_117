package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/violations")
@RequiredArgsConstructor
public class ViolationRecordController {

    private final ViolationRecordService violationService;

    // POST /api/violations - Log a new violation
    @PostMapping
    @Transactional
    public ResponseEntity<ViolationRecord> logViolation(@Valid @RequestBody ViolationRecord violation) {
        ViolationRecord saved = violationService.saveViolation(violation);
        return ResponseEntity.ok(saved);
    }

    // GET /api/violations/user/{userId} - Get violations by user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ViolationRecord>> getViolationsByUser(@PathVariable Long userId) {
        List<ViolationRecord> violations = violationService.getViolationsByUser(userId);
        return ResponseEntity.ok(violations);
    }

    // GET /api/violations/unresolved - List unresolved violations
    @GetMapping("/unresolved")
    public ResponseEntity<List<ViolationRecord>> getUnresolvedViolations() {
        List<ViolationRecord> violations = violationService.getUnresolvedViolations();
        return ResponseEntity.ok(violations);
    }

    // GET /api/violations - List all violations
    @GetMapping
    public ResponseEntity<List<ViolationRecord>> getAllViolations() {
        List<ViolationRecord> violations = violationService.getAllViolations();
        return ResponseEntity.ok(violations);
    }

    // PUT /api/violations/{id}/resolve - Mark violation as resolved
    @PutMapping("/{id}/resolve")
    @Transactional
    public ResponseEntity<ViolationRecord> resolveViolation(@PathVariable Long id) {
        ViolationRecord resolved = violationService.resolveViolation(id);
        return ResponseEntity.ok(resolved);
    }
}
