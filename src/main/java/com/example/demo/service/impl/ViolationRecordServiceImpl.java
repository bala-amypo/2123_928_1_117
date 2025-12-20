package com.example.demo.service.impl;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ViolationRecordServiceImpl implements ViolationRecordService {

    @Autowired
    private ViolationRecordRepository violationRepo;

    @Override
    public ViolationRecord save(ViolationRecord record) {
        return violationRepo.save(record);
    }

    @Override
    public List<ViolationRecord> getUserViolations(Long userid) {
        return violationRepo.findByUserid(userid);
    }

    @Override
    public List<ViolationRecord> getUnresolvedViolations() {
        return violationRepo.findByResolvedFalse();
    }
}