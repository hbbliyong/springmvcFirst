package com.ly.springmvcFirst.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/5/9.
 */
@RestController
@RequestMapping("/")
public class HelloController {
    @RequestMapping("/index")
    public String hello(){
        return "index";
    }
}
