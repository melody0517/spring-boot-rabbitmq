package com.sjn.producer.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @date: 2020/8/6
 * @author: ShiJiaNan
 */
@SpringBootTest
public class MessageServiceImplTest {

    @Autowired
    private ProducerMessage producerMessage;

//    @Test
    public void sendMsg() throws InterruptedException {
        //先入后消费
        producerMessage.sendMsg("hello", 20 * 1000);
        Thread.sleep(10 * 1000);
        //后入先消费
        producerMessage.sendMsg("1111", 2 * 1000);
        new CountDownLatch(1).await();
    }
}