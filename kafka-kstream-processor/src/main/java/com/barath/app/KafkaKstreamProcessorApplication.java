package com.barath.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.binder.kstream.annotations.KStreamProcessor;



@SpringBootApplication
@EnableBinding(KStreamProcessor.class)
public class KafkaKstreamProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaKstreamProcessorApplication.class, args);
	}
}
