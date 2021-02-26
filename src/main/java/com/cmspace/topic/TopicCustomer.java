package com.cmspace.topic;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: miao.cheng
 * @Date: 2021/2/26 09:52
 * @Description:
 */
@Component
public class TopicCustomer {

    @RabbitListener(
        bindings = @QueueBinding(
                value = @Queue,//创建临时队列
                exchange = @Exchange(name = "topics",type = "topic"),//绑定交换机
                key = {"user.*","user.save"}
        )
    )
    public void recevicel1(String message){
        System.out.println("消费者1："+message);
    }

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue,//创建临时队列
                    exchange = @Exchange(name = "topics",type = "topic"),//绑定交换机
                    key = {"*.user.*","user.*","user.#","#.user.#"}
            )
    )
    public void recevicel2(String message){
        System.out.println("消费者2："+message);
    }

}
