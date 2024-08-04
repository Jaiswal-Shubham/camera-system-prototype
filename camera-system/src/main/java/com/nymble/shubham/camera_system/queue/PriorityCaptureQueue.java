package com.nymble.shubham.camera_system.queue;


import com.nymble.shubham.camera_system.model.CaptureRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.PriorityBlockingQueue;

@Component
public class PriorityCaptureQueue {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private PriorityBlockingQueue<CaptureRequest> queue;

    public PriorityCaptureQueue() {
        queue = new PriorityBlockingQueue<>();
    }

    public void enqueue(CaptureRequest request) {
        logger.info("Enqueuing capture request with urgency: {}", request.getUrgency());
        queue.put(request);
        logger.info("Queue size after enqueuing: {}", queue.size());
    }

    public CaptureRequest dequeue() throws InterruptedException {
        return queue.take();
    }

    public int getSize(){
        return queue.size();
    }
}

