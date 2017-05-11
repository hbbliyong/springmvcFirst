package com.ly.springmvcFirst.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by Administrator on 2017/5/9.
 * SpringMVC的基本配置
 */
@Configuration
@EnableWebMvc //开启默认配置,如果没有此注解，重写WebMvcConfigurerAdapter方法无效
@ComponentScan("com.ly.springmvcFirst")
public class MyMvcConfig extends WebMvcConfigurerAdapter{
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);

        return  viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/assets/**")//对外暴露的访问路径
                .addResourceLocations("classpath:/assets/");//文件放置目录
    }

    //配置过滤器
    //创建拦截器对象
    @Bean
    public CustomInterceptor myInterceptor()
    {
        return new CustomInterceptor();
    }
//添加自定义拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor());
    }

    //路由映射的快捷设置

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/jqueryTest").setViewName("jquery_test");
    }
}
