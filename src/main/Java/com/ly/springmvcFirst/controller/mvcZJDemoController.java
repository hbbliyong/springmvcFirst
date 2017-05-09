package com.ly.springmvcFirst.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/5/9.
 * SpringMVC各种注解DEMO
 */
@RestController
@RequestMapping("/zj")
public class mvcZJDemoController {
    @RequestMapping(produces = "text/plain;charset=UTF-8;xx=123")
    public @ResponseBody String index(HttpServletRequest request){
        return "url:"+request.getRequestURI()+" can assess";
    }

    @RequestMapping(value="/pathvar/{str}")
    public String demoPathVar(@PathVariable String str,HttpServletRequest request){
        return "url: "+request.getRequestURI()+" can access,str: "+str;
    }

    @RequestMapping(value="requestParam")
    public String passRequestParam(Long id,HttpServletRequest request){
        return "url: "+request.getRequestURI()+" can access,str: "+id;
    }


}
