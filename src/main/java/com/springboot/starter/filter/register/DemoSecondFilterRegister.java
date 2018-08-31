package com.springboot.starter.filter.register;

import com.springboot.starter.filter.DemoSecondFilter;
import com.springboot.starter.filter.consts.OrderConst;
import com.springboot.starter.consts.UrlPatternConst;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class DemoSecondFilterRegister {

    private final static String NAME = "DemoSecondFilter";
    private final static String REGISTER_NAME = "demoSecondFilterRegistrationBean";

    @Bean(name = REGISTER_NAME)
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(demoSecondFilter());
        filterRegistrationBean.setName(NAME);
        filterRegistrationBean.addUrlPatterns(UrlPatternConst.ALL_URL);
        filterRegistrationBean.setOrder(OrderConst.SECOND);
        return filterRegistrationBean;
    }

    @Bean
    public Filter demoSecondFilter() {
        return new DemoSecondFilter();
    }
}
