package com.example.loadtestkafka.controller;


import com.example.loadtestkafka.model.User;
import com.example.loadtestkafka.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
public class PublisherController {

    private final ServerProperties serverProperties;
    private final PublisherService publisherService;

    Logger logger = Logger.getLogger(this.getClass().getName());

    @GetMapping("/apis/publish/helloWorld")
    public String helloWorld() {

        return "Publish Hello World from  Port:" + serverProperties.getPort();

    }

    @PostMapping("apis/publish/publishMessage/{msgCount}")
    public String publishMessage(@RequestBody User user,   @RequestHeader Map<String, String> headers,@PathVariable int msgCount) {
//          headers.forEach((key, value) -> {
//            logger.info(String.format("Header '%s' = %s", key, value));
//        });
//        //

            publisherService.createMessages(user,msgCount);

        System.out.println("----------------------------------" +msgCount + " Messages are published ");
//
        return (msgCount + " Messages are published ");



    }
}
