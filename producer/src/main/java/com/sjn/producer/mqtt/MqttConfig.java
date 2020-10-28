package com.sjn.producer.mqtt;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description: mqtt配置信息
 * @date: 2020/10/27
 * @author: ShiJiaNan
 */
@Data
@Component
@ConfigurationProperties(prefix = "spring.rabbitmq.mqtt")
public class MqttConfig {
    /**
     * RabbitMQ连接用户名
     */
    private String username;

    /**
     * RabbitMQ连接密码
     */
    private String password;

    /**
     * RabbitMQ的MQTT默认topic
     */
    private String defaultTopic;

    /**
     * RabbitMQ的MQTT连接地址
     */
    private String url;
}
