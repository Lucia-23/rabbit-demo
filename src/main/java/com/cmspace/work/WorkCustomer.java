package com.cmspace.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: miao.cheng
 * @Date: 2021/2/25 16:16
 * @Description:
 */
@Component
public class WorkCustomer {

    @RabbitHandler
    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void recrvicel1(String message){
        System.out.println("work1:"+message);
    }

    @RabbitHandler
    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void recrvicel2(String message){
        System.out.println("work2:"+message);
    }

}
