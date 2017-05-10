package com.ly.springmvcFirst.controller;

import com.ly.springmvcFirst.entity.User;
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

    @RequestMapping(value = "/obj",produces = "application/json;charset=UTF-8")
    public String passObj(User user,HttpServletRequest request){
        return "url:" +request.getRequestURI()+" can assess ,obj id: "+user.getId()+" obj name:"+user.getName();
    }

    @RequestMapping(value={"/name1","/name2"},produces = "application/json;charset=UTF-8")
    public String remove(HttpServletRequest request){
        return "url:" +request.getRequestURI()+" can assess";
    }

    @RequestMapping(value = "getjson",produces = "application/json;charset=UTF-8")
    public User getUser(){
        User user=new User();
        user.setId(111);
        user.setName("hbbliyong");
        return user;
    }

}
