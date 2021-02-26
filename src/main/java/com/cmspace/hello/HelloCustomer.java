package com.cmspace.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: miao.cheng
 * @Date: 2021/2/25 16:01
 * @Description:
 */
@Component
                                    //默认持久化 非独占的 不是默认删除的
@RabbitListener(queuesToDeclare = @Queue(value = "hello",durable = "false",autoDelete = "true"))
public class HelloCustomer {

    @RabbitHandler
    public void receivel(String message){
        System.out.println("message："+message);
    }

}
