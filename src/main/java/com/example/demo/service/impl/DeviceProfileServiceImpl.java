package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DeviceProfileServiceImpl implements DeviceProfileService {

    private final DeviceProfileRepository repo;

    public DeviceProfileServiceImpl(DeviceProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public DeviceProfile registerDevice(DeviceProfile device) {

        Optional<DeviceProfile> existing =
                repo.findByDeviceId(device.getDeviceId());

        if (existing.isPresent() &&
            existing.get().getUserId().equals(device.getUserId())) {
            throw new BadRequestException("Device already registered for user");
        }

        device.setLastSeen(LocalDateTime.now());
        return repo.save(device);
    }

    @Override
    public DeviceProfile updateTrustStatus(Long id, boolean trust) {
        DeviceProfile device = repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Device not found"));

        device.setIsTrusted(trust);
        device.setLastSeen(LocalDateTime.now());
        return repo.save(device);
    }

    @Override
    public List<DeviceProfile> getDevicesByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public Optional<DeviceProfile> findByDeviceId(String deviceId) {
        return repo.findByDeviceId(deviceId);
    }
}
