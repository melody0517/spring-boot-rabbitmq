package com.sjn.producer.controller;

import com.sjn.producer.model.Notice;
import com.sjn.producer.service.NoticeService;
import com.sjn.producer.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 系统公告
 * @date: 2020/10/27
 * @author: ShiJiaNan
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @PostMapping("/create")
    public CommonResult create(@RequestBody Notice notice) {
        noticeService.create(notice, true);
        return CommonResult.success(null);
    }
}
