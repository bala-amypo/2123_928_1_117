package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {

    @Autowired
    private DeviceProfileService deviceService;

    @PostMapping
    public DeviceProfile save(@RequestBody DeviceProfile profile) {
        return deviceService.save(profile);
    }

    @GetMapping("/{deviceid}")
    public DeviceProfile getDevice(@PathVariable String deviceid) {
        return deviceService.findByDeviceId(deviceid);
    }

    @GetMapping("/user/{userid}")
    public List<DeviceProfile> getUserDevices(@PathVariable Long userid) {
        return deviceService.getUserDevices(userid);
    }
}