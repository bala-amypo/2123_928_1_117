package com.example.demo.service;

import com.example.demo.entity.ViolationRecord;
import java.util.List;

public interface ViolationRecordService {

    ViolationRecord save(ViolationRecord record);

    List<ViolationRecord> getUserViolations(Long userid);

    List<ViolationRecord> getUnresolvedViolations();
}