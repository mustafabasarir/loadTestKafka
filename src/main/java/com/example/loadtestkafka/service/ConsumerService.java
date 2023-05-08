package com.example.loadtestkafka.service;

import com.example.loadtestkafka.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class ConsumerService {


    Logger logger = Logger.getLogger(this.getClass().getName());

    private long maxTimeDiff=0;

    @KafkaListener(topics = {"${loadTestKafka.topics.name}"}, groupId = "sample-kafka-group")
    public void readMsg(User user) throws ParseException {

//        try {
//            Thread.sleep(30000);
//        } catch (InterruptedException e) {
//            System.out.println(e.getMessage());
//        }
        Date createTime = new SimpleDateFormat("HH:mm:ss.SSSSSS").parse(user.getMsgTime());
        Date currentDate = new Date();
        long diffInMillies = currentDate.getTime() -createTime.getTime() ;
        if (diffInMillies>maxTimeDiff) maxTimeDiff = diffInMillies;

        logger.info("REad from Topic : " + user.getId() + " current :" + new SimpleDateFormat("HH:mm:ss.SSSSSS").format(currentDate) + " create :" + user.getMsgTime() + "  diff : " + diffInMillies  );

        logger.info("----------------------Maxx:" + maxTimeDiff);


    }


//    @KafkaListener(topics = {"${loadTestKafka.topics.name}"}, groupId = "consumer-kafka-group1", batch = "true")
//    public String readBatchMsg@Payload List<User> users, @Header(KafkaHeaders.OFFSET) List<Long> offsets)  {
//
//        // logger.info("offset 0:  : " +offsets.get(0));
//        for (int i = 0; i < persons.size(); i++) {
//            //  logger.info("Received message = " +i +" " + persons.get(i).toString());
//            //    logger.info("Received message = " + i + " " + persons.get(i).toJSON());
//        }
//        if (persons.size() > 1) logger.info("All batch messages received  size : " + persons.size());
//
//        return null;
//    }
//

}
