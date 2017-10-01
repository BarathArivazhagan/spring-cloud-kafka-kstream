package com.barath.app;


import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.binder.kafka.admin.Kafka10AdminUtilsOperation;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableBinding(Sink.class)
public class KafkaSinkConfiguration {




    @StreamListener(value = Sink.INPUT)
    public void consumeMessages(KStream<?,String> input){
        System.out.println("MESSAGE RECEIVED AT SINK ");
        input.print();
    }
}
