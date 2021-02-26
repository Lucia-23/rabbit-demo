package com.cmspace;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = RabbitDemo1Application.class)
@RunWith(SpringRunner.class)
class RabbitDemo1ApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //topic 动态路由模式
    @Test
    void testTopic(){
        rabbitTemplate.convertAndSend("topics","aaa.bbb.user.save.ccc","动态路由消息");
    }

    //route 路由模式
    @Test
    void testRoulte(){
        rabbitTemplate.convertAndSend("directs","error","route 消息");
    }

    //fanout模式
    @Test
    void testFanOut(){
        rabbitTemplate.convertAndSend("logs","","fanout消息");
    }

    //work模式
    @Test
    void testWork(){
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work","work模型");
        }
    }

    //hello模式
    @Test
    void testHello() {
        rabbitTemplate.convertAndSend("hello","hello world");
    }

}
