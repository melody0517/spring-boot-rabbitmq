package com.sjn.producer.service.impl;

import com.alibaba.fastjson.JSON;
import com.sjn.producer.enums.RoleEnums;
import com.sjn.producer.model.Notice;
import com.sjn.producer.mqtt.MqttGateway;
import com.sjn.producer.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: 系统公告
 * @date: 2020/10/27
 * @author: ShiJiaNan
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private MqttGateway mqttGateway;

    @Override
    public void create(Notice notice, boolean isSend) {
        //之后可以通过isSend控制发送
        //获取主题
        RoleEnums byCode = RoleEnums.getByCode(notice.getReceiveType());
        mqttGateway.sendToMqtt(JSON.toJSONString(notice), byCode.getName());
    }
}
