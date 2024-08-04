package com.nymble.shubham.camera_system.worker;


import com.nymble.shubham.camera_system.model.CaptureRequest;
import com.nymble.shubham.camera_system.model.CaptureResult;
import com.nymble.shubham.camera_system.queue.PriorityCaptureQueue;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CaptureWorker {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PriorityCaptureQueue priorityCaptureQueue;

    public CaptureWorker(PriorityCaptureQueue queue) {
        this.priorityCaptureQueue = queue;
    }

    @PostConstruct
    public void start() {
        Thread workerThread = new Thread(() -> {
            while (true) {
                try {
                    CaptureRequest request = priorityCaptureQueue.dequeue();
                    processCaptureRequest(request);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        workerThread.setDaemon(true);
        workerThread.start();
    }

    private void processCaptureRequest(CaptureRequest request) {
        // Simulate image capturing logic
        boolean success = Math.random() > 0.4; // 60% success rate
        logger.info("Received capture request: {} with success status: {}",request,success);
        CaptureResult result;
        if (success) {
            result = new CaptureResult("CapturedImage", null);
            logger.info("notifying client for success");
            logger.info("callback url: {}",request.getSuccessCallback().getOnSuccess());
            logger.info("message: {}",result.getCapturedImage());
            request.getSuccessCallback().setSuccessFromCallback(result);
        } else {
            result = new CaptureResult(null, "Capture failed");
            logger.info("notifying client for failure");
            logger.info("callback url: {}",request.getFailureCallback().getOnFailure());
            logger.info("error: {}",result.getErrorMessage());
            request.getFailureCallback().setOnFailureFromCallback(result);
        }
    }
}

