package com.example.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Copyright (c) 政采云有限公司
 * @Title：
 * @Date: 2024/1/4
 * @Time: 15:01
 * @Author: 对半
 */
@RestController
public class TestController {

    @GetMapping(value = "/helloWord")
    public String helloWord() {
        return "hello word!";
    }
}
