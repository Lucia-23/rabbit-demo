package com.cmspace.fanout;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * @Auther: miao.cheng
 * @Date: 2021/2/25 17:46
 * @Description:
 */
@Component
public class FanOutCustomer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//创建临时队列
                    exchange = @Exchange(value = "logs",type = "fanout")//绑定交换机
            )
    })
    public void recevicel1(String message){
        System.out.println("消费者1："+message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//创建临时队列
                    exchange = @Exchange(value = "logs",type = "fanout")//绑定交换机
            )
    })
    public void recevicel2(String message){
        System.out.println("消费者2："+message);
    }

}
