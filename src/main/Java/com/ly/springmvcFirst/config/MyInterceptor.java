package com.ly.springmvcFirst.config;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 * 可以通过让普通的Beam实现HandlerInterceptor接口或者继承HandlerInterceptorAdapter
 * 来实现自定义拦截器
 * （拦截器：INterceptor）实现对每一个请求处理前后进行相关业务的处理，类似Servlet的Filter
 * Created by Administrator on 2017/5/10.
 */
public class MyInterceptor extends HandlerInterceptorAdapter{
    //请求之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       long startTime=System.currentTimeMillis();
       request.setAttribute("startTime",startTime);
        return true;
    }

    //请求之后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
       long startTime=(long)request.getAttribute("startTime");
       request.removeAttribute("startTime");
       long endTime=System.currentTimeMillis();

        System.out.println("本次请求的时间为："+new Long(endTime-startTime)+"ms");
        request.setAttribute("handlingTime",endTime-startTime);
    }
}
