package com.cmspace;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(RabbitDemo1Application.class, args);
    }

}
