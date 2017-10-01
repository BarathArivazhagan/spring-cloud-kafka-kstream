package com.barath.app;


import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KStreamBuilder;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import java.util.concurrent.atomic.AtomicInteger;


@EnableBinding(Source.class)
public class KafkaSourceConfiguration {

    private AtomicInteger counter=new AtomicInteger(0);
    private KStreamBuilder builder = new KStreamBuilder();


    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT,poller = @Poller(fixedRate = "1000"))
    public MessageSource<String> source(){

        return new MessageSource<String>() {
        	
        	@Override
        	public Message<String> receive() {
        		return MessageBuilder.withPayload("stream message "+counter.getAndDecrement()).build();
        	}
		};

    }
}



