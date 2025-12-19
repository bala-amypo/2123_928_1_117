package com.example.demo.service.impl;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.DeviceProfileRepository;
import com.example.demo.service.DeviceProfileService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class DeviceProfileServiceImpl implements DeviceProfileService {

    @Autowired
    private DeviceProfileRepository deviceRepo;

    @Override
    public DeviceProfile save(DeviceProfile profile) {
        return deviceRepo.save(profile);
    }

    @Override
    public DeviceProfile findByDeviceId(String deviceid) {
        return deviceRepo.findByDeviceid(deviceid)
                .orElseThrow(() -> new ResourceNotFoundException("Device not found: " + deviceid));
    }

    @Override
    public List<DeviceProfile> getUserDevices(Long userid) {
        return deviceRepo.findByUserid(userid);
    }
}