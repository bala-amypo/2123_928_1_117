package com.example.demo.controller;

import com.example.demo.entity.DeviceProfile;
import com.example.demo.service.DeviceProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceProfileController {

    private final DeviceProfileService service;

    public DeviceProfileController(DeviceProfileService service) {
        this.service = service;
    }

    // ------------------ Register device ------------------
    @PostMapping("/register")
    public ResponseEntity<DeviceProfile> registerDevice(@RequestBody DeviceProfile device) {
        DeviceProfile registered = service.registerDevice(device);
        return ResponseEntity.ok(registered);
    }

    // ------------------ Update trusted status ------------------
    @PutMapping("/{id}/trust")
    public ResponseEntity<DeviceProfile> updateTrust(@PathVariable Long id, @RequestParam boolean trust) {
        DeviceProfile updated = service.updateTrustStatus(id, trust);
        return ResponseEntity.ok(updated);
    }

    // ------------------ Get devices by user ------------------
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<DeviceProfile>> getDevicesByUser(@PathVariable Long userId) {
        List<DeviceProfile> devices = service.getDevicesByUser(userId);
        return ResponseEntity.ok(devices);
    }

    // ------------------ Lookup device by deviceId ------------------
    @GetMapping("/lookup/{deviceId}")
    public ResponseEntity<DeviceProfile> getDeviceById(@PathVariable String deviceId) {
        DeviceProfile device = service.findByDeviceId(deviceId)
                .orElseThrow(() -> new RuntimeException("Device not found"));
        return ResponseEntity.ok(device);
    }
}
