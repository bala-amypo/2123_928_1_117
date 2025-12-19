package com.example.demo.controller;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.service.ViolationRecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/violations")
public class ViolationRecordController {

    @Autowired
    private ViolationRecordService violationService;

    @PostMapping
    public ViolationRecord save(@RequestBody ViolationRecord record) {
        return violationService.save(record);
    }

    @GetMapping("/user/{userid}")
    public List<ViolationRecord> getUserViolations(@PathVariable Long userid) {
        return violationService.getUserViolations(userid);
    }

    @GetMapping("/unresolved")
    public List<ViolationRecord> getUnresolved() {
        return violationService.getUnresolvedViolations();
    }
}