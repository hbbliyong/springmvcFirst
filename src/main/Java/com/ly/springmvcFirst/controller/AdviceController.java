package com.ly.springmvcFirst.controller;

import com.ly.springmvcFirst.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 全局异常处理测试控制器
 * Created by Administrator on 2017/5/10.
 */
@Controller
public class AdviceController {
    @RequestMapping("/advice")
    public String getSomething(@ModelAttribute("msg") String msg, User user){
        throw new IllegalArgumentException("非常抱歉，参数有误/"+"来自@ModelAttribute:"+msg);
    }
}
