package com.example.demo.service;

import com.example.demo.entity.DeviceProfile;
import java.util.List;

public interface DeviceProfileService {

    DeviceProfile save(DeviceProfile profile);

    DeviceProfile findByDeviceId(String deviceid);

    List<DeviceProfile> getUserDevices(Long userid);
}