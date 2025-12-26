package com.example.demo.service.impl;

import com.example.demo.entity.ViolationRecord;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.ViolationRecordRepository;
import com.example.demo.service.ViolationRecordService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class ViolationRecordServiceImpl implements ViolationRecordService {

    private final ViolationRecordRepository repo;

    public ViolationRecordServiceImpl(ViolationRecordRepository repo) {
        this.repo = repo;
    }

    @Override
    public ViolationRecord logViolation(ViolationRecord v) {
        v.setDetectedAt(LocalDateTime.now());
        if (v.getResolved() == null) v.setResolved(false);
        return repo.save(v);
    }

    @Override
    public ViolationRecord markResolved(Long id) {
        ViolationRecord v = repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Violation not found"));
        v.setResolved(true);
        return repo.save(v);
    }

    @Override
    public List<ViolationRecord> getViolationsByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public List<ViolationRecord> getUnresolvedViolations() {
        return repo.findByResolvedFalse();
    }

    @Override
    public List<ViolationRecord> getAllViolations() {
        return repo.findAll();
    }
}
