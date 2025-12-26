package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {

    private final DeviceProfileService service;

    public DeviceProfileController(DeviceProfileService service) {
        this.service = service;
    }

    // ✅ Register Device
    @PostMapping("/register")
    public DeviceProfile register(@RequestBody DeviceProfile device) {
        return service.registerDevice(device);
    }

    // ✅ Update Trust Status
    @PutMapping("/{id}/trust/{status}")
    public DeviceProfile trust(@PathVariable Long id,
                               @PathVariable boolean status) {
        return service.updateTrustStatus(id, status);
    }

    // ✅ Devices by User
    @GetMapping("/user/{userId}")
    public List<DeviceProfile> devices(@PathVariable Long userId) {
        return service.getDevicesByUser(userId);
    }
}
