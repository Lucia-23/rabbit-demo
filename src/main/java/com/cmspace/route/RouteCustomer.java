package com.cmspace.route;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Auther: miao.cheng
 * @Date: 2021/2/26 09:33
 * @Description:
 */
@Component
public class RouteCustomer {

    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue,//创建临时队列
            exchange = @Exchange(value = "directs", type = "direct"),//绑定交换机
            key = {"error", "info", "warning"}
    )
    )
    public void recevicel1(String message) {
        System.out.println("消费者1：" + message);
    }

    @RabbitListener(bindings =
    @QueueBinding(
            value = @Queue,//创建临时队列
            exchange = @Exchange(value = "directs", type = "direct"),//绑定交换机
            key = ("error")
    )
    )
    public void recevicel2(String message) {
        System.out.println("消费者2：" + message);
    }

}
