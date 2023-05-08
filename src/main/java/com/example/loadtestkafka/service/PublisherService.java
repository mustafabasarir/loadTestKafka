package com.example.loadtestkafka.service;


import com.example.loadtestkafka.model.User;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class PublisherService {

    private long value = 1;

    Logger logger = Logger.getLogger(this.getClass().getName());

    @Value( value ="${loadTestKafka.topics.name}")
    private String msgTopicName;

private final KafkaTemplate<String , User> kafkaTemplate;


    public void createMessages (User user,int msgCount){

        for (int i = 0; i < msgCount; i++) {
            getNext(user);
            kafkaTemplate.send (msgTopicName,user);
            logger.info("Write to Topic User id " + user.getId() + "  Time: "  + user.getMsgTime());

        }


    }

    public synchronized void getNext(User user) {
        value += 1;
        user.setId(String.valueOf(value));
        user.setMsgTime(new SimpleDateFormat("HH:mm:ss.SSSSSS").format(new Date()));
    }

}
