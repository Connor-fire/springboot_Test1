package com.bistu.springboot01helloworldquick.configuration;

import com.bistu.springboot01helloworldquick.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {//springMVC配置扩展
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/lin").setViewName("success");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/user/login","/asserts/**","/webjars/**","/user/register","/addUser");
    }

    //    public WebMvcConfigurer WebMvcConfigurer(){
//        WebMvcConfigurer configurer = new WebMvcConfigurer(){
//            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/").setViewName("login");
//                registry.addViewController("/index.html").setViewName("login");
//                registry.addViewController("/main.html").setViewName("dashboard");
//            }
//        };
//        return configurer;
//    }
}
