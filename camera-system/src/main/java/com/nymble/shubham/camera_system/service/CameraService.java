package com.nymble.shubham.camera_system.service;


import com.nymble.shubham.camera_system.model.CaptureRequest;
import com.nymble.shubham.camera_system.queue.PriorityCaptureQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CameraService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PriorityCaptureQueue priorityCaptureQueue;

    public void submitCaptureRequest(CaptureRequest request) {
        priorityCaptureQueue.enqueue(request);
        logger.info("Queue size is: {}",priorityCaptureQueue.getSize());

    }
}
