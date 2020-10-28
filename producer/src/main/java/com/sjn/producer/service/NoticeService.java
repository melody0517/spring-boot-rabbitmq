package com.sjn.producer.service;

import com.sjn.producer.model.Notice;

/**
 * @description: 系统公告
 * @date: 2020/10/27
 * @author: ShiJiaNan
 */
public interface NoticeService {

    /**
     * 创建公告信息.
     *
     * @param notice
     * @param isSend 是否立即发送
     */
    void create(Notice notice, boolean isSend);
}
