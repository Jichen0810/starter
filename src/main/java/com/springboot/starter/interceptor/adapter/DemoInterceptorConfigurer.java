package com.springboot.starter.interceptor.adapter;

import com.springboot.starter.consts.UrlPatternConst;
import com.springboot.starter.interceptor.DemoHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DemoInterceptorConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoHandlerInterceptor()).addPathPatterns(UrlPatternConst.ALL_URL);
    }

    @Bean
    public DemoHandlerInterceptor demoHandlerInterceptor() {
        return new DemoHandlerInterceptor();
    }
}
