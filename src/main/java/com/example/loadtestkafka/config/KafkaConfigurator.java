package com.example.loadtestkafka.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class KafkaConfigurator {
    @Value( value ="${loadTestKafka.topics.name}")
    private String msgTopicName;



    @Bean
    public NewTopic msgTopic(){
        System.out.println( new Date().getTime() +  " Topic Created");
        return new NewTopic(msgTopicName,1,(short)1);

    }



}
