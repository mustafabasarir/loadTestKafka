package com.example.loadtestkafka.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.Getter;
import lombok.Setter;
import org.apache.kafka.clients.consumer.StickyAssignor;

@Getter
@Setter

public class User  {

    String firstName;
    String lastName;
    String email;


    String id;
    String msgTime ;





    @Override
    public String toString() {
        return "User : " + this.firstName + " + " + this.lastName + "+" + this.email;
    }



}
