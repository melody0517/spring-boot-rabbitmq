package com.sjn.producer.mqtt.test;

import com.sjn.producer.mqtt.MqttGateway;
import com.sjn.producer.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 网关测试接口
 * @date: 2020/10/27
 * @author: ShiJiaNan
 */
@RestController
@RequestMapping("mqtt")
public class MqttController {

    @Autowired
    private MqttGateway mqttGateway;

    /**
     * 发送消息到默认topic.
     *
     * @param payload 消息体
     * @return: {@link CommonResult}
     */
    @PostMapping("/sendToDefaultTopic")
    public CommonResult sendToDefaultTopic(String payload) {
        mqttGateway.sendToMqtt(payload);
        return CommonResult.success(null);
    }

    /**
     * 发送消息到指定topic.
     *
     * @param payload 消息体
     * @param topic   主题名称
     * @return: {@link CommonResult}
     */
    @PostMapping("/sendToTopic")
    public CommonResult sendToTopic(String payload, String topic) {
        mqttGateway.sendToMqtt(payload, topic);
        return CommonResult.success(null);
    }
}
