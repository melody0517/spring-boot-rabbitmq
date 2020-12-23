package com.sjn.producer.mqtt;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/**
 * @description: MQTT网关，用于向主题中发送消息
 * @date: 2020/10/27
 * @author: ShiJiaNan
 */
@Component
@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MqttGateway {

    /**
     * 发送消息到默认topic.
     *
     * @param payload 消息体
     */
    void sendToMqtt(String payload);

    /**
     * 发送消息到指定topic.
     *
     * @param payload 消息体
     * @param topic   主题
     */
    void sendToMqtt(String payload, @Header(MqttHeaders.TOPIC) String topic);

    /**
     * 发送消息到指定topic并设置QOS.
     *
     * @param topic   主题
     * @param qos     消息质量：0->至多一次；1->至少一次；2->只有一次
     * @param payload 消息体
     */
    void sendToMqtt(@Header(MqttHeaders.TOPIC) String topic, @Header(MqttHeaders.QOS) int qos, String payload);
}
