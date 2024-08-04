package com.nymble.shubham.camera_system;

import com.nymble.shubham.camera_system.queue.PriorityCaptureQueue;
import com.nymble.shubham.camera_system.worker.CaptureWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CameraSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CameraSystemApplication.class, args);
	}

	@Bean
	public PriorityCaptureQueue priorityCaptureQueue() {
		return new PriorityCaptureQueue();
	}

	@Bean
	public CaptureWorker captureWorker(PriorityCaptureQueue queue) {
		return new CaptureWorker(queue);
	}
}

