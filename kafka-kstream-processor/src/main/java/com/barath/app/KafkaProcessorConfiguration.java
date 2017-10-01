package com.barath.app;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.SendTo;

import java.util.Arrays;

@Configuration
public class KafkaProcessorConfiguration {


    @StreamListener(value = "input")
    @SendTo("output")
    public KStream<?, String> splitStrings(KStream<?, String> input) {
        input.print();
        System.out.println("PROCESSOR WITH INPUT "+input.toString());
        return input
                .flatMapValues(value -> Arrays.asList(value.toLowerCase().split("\\W+")));
    }
}
