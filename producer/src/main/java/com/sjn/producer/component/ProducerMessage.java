package com.sjn.producer.component;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 发送消息
 * @date: 2020/8/6
 * @author: ShiJiaNan
 */
@Component
public class ProducerMessage {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsg(String msg, long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("消息发送时间:" + sdf.format(new Date()));
        rabbitTemplate.convertAndSend("test_exchange", "test_queue_1", msg, message -> {
            message.getMessageProperties().setHeader("x-delay", time);
            return message;
        });
    }
}