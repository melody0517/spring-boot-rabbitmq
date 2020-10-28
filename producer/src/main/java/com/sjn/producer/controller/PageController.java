package com.sjn.producer.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: 进入首页
 * @date: 2020/10/27
 * @author: ShiJiaNan
 */
@Controller
@RequestMapping("/page")
public class PageController {

    @GetMapping("/enter")
    public String index() {
        return "index";
    }
}
