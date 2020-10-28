package com.sjn.producer.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @description: 系统消息和用户关联(用于标记消息是否已读)
 * web端登录进入首页获取未读消息的条数，小程序直接展示未读消息
 * @date: 2020/10/27
 * @author: ShiJiaNan
 */
@Data
public class MessageUserMap implements Serializable {

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 系统消息ID
     */
    private Integer messageId;

    /**
     * 状态 0未读 1已读
     */
    private Byte status;


}
