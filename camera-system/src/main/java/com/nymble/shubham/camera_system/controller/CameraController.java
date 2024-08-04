package com.nymble.shubham.camera_system.controller;

import com.nymble.shubham.camera_system.model.CaptureRequest;
import com.nymble.shubham.camera_system.service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/camera")
public class CameraController {

    @Autowired
    private CameraService cameraService;

    @PostMapping("/capture")
    public String captureImage(@RequestBody CaptureRequest request) {
        cameraService.submitCaptureRequest(request);
        return "Capture request submitted";
    }
}

