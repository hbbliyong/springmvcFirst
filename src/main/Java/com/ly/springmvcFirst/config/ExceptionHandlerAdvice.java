package com.ly.springmvcFirst.config;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理类
 * Created by Administrator on 2017/5/10.
 */
@ControllerAdvice//声明一个控制器建言，@ControllerAdvice组合了@Componet注解，所以自动注册为Spring的Bean.
public class ExceptionHandlerAdvice {
    @ExceptionHandler(value = Exception.class)//此处用于全局处理控制器里的异常，其它过滤条件也可以放到Value里面
    public ModelAndView exception(Exception ex, WebRequest webRequest){
        ModelAndView modelAndView=new ModelAndView("error");
        modelAndView.addObject("errorMessage",ex.getMessage());
        System.out.println("ex = [" + ex.getMessage() + "], webRequest = [" + webRequest.getContextPath() + "]");
        return modelAndView;
    }

    @ModelAttribute//此注解将键值对添加到全局，所有注解的@RequestMapping的方法可获得此键值对
    public void addAttributes(Model model){
        model.addAttribute("msg","额外信息");
    }

    @InitBinder//通过此注解定制WebDataBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");
    }
}
