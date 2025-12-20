package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/violations")
@Tag(name = "Violation Record Controller")
public class ViolationRecordController {

    private final ViolationRecordService violationService;

    // ✅ Constructor Injection (NO @Autowired)
    public ViolationRecordController(ViolationRecordService violationService) {
        this.violationService = violationService;
    }

    // ✅ POST /api/violations
    @PostMapping
    public ViolationRecord save(@RequestBody ViolationRecord record) {
        return violationService.save(record);
    }

    // ✅ GET /api/violations/user/{userid}
    @GetMapping("/user/{userid}")
    public List<ViolationRecord> getUserViolations(@PathVariable Long userid) {
        return violationService.getUserViolations(userid);
    }

    // ✅ GET /api/violations/unresolved
    @GetMapping("/unresolved")
    public List<ViolationRecord> getUnresolvedViolations() {
        return violationService.getUnresolvedViolations();
    }
}
