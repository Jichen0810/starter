package com.springboot.starter.filter.register;

import com.springboot.starter.filter.DemoFilter;
import com.springboot.starter.filter.consts.OrderConst;
import com.springboot.starter.filter.consts.UrlPatternConst;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class DemoFilterRegister {

    private final static String NAME = "DemoFilter";
    private final static String REGISTER_NAME = "demoFilterRegistrationBean";

    @Bean(name = REGISTER_NAME)
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(demoFilter());
        filterRegistrationBean.setName(NAME);
        filterRegistrationBean.addUrlPatterns(UrlPatternConst.ALL_URL);
        filterRegistrationBean.setOrder(OrderConst.SECOND);
        return filterRegistrationBean;
    }

    @Bean
    public Filter demoFilter() {
        return new DemoFilter();
    }
}
