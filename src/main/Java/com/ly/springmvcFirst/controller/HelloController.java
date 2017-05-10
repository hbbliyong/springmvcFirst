package com.ly.springmvcFirst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/5/9.
 */
@Controller
@RequestMapping("/")
public class HelloController {
    @RequestMapping("/index")
    public String hello(){
        return "index";
    }

    @RequestMapping( value = "/",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getIndex(){
        return "Hello world!中国人！";
    }
}
