package com.sjn.producer.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 系统消息
 * @date: 2020/10/27
 * @author: ShiJiaNan
 */
@Data
public class Notice implements Serializable {

    /**
     * 标题
     */
    private String title;

    /**
     * 正文
     */
    private String message;

    /**
     * 发件人用户ID
     */
    private Integer senderId;

    /**
     * 发件人姓名
     */
    private String senderName;

    /**
     * 广播类型 0全网广播 其他数字为对应的角色ID
     * 各个应用端在用户登录成功后，获取对应的角色名称，订阅全网广播主题和对应角色的主题
     */
    private Integer receiveType;

    /**
     * 接收人（全网广播，角色对应的名称）
     */
    private String receive;

    /**
     * 是否已发送 0未发送 1已发送
     */
    private Byte status;
}
