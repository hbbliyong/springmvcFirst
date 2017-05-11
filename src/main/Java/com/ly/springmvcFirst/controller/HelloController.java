package com.ly.springmvcFirst.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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
    @RequestMapping("/view")
    public ModelAndView message(HttpServletRequest request){
        //这里注意要加上页面参数，如果不加，他会默认请求地址的页面也就是会找view.jsp,而我们这里是要对应到message.jsp上面
        ModelAndView modelAndView=new ModelAndView("message");
        modelAndView.addObject("message_key","hello world,中国人！");
        return modelAndView;
    }
}
