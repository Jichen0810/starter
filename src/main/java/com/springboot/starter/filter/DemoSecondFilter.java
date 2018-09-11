package com.springboot.starter.filter;

import com.springboot.starter.consts.GlobalConst;
import com.springboot.starter.filter.consts.OrderConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter(filterName = "demoSecondFilter", urlPatterns = UrlPatternConst.ALL_URL)
@Order(OrderConst.FIRST)
@Slf4j
public class DemoSecondFilter implements Filter {
    @Override
    public void destroy() {
        log.info("DemoSecondFilter destroy.");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("DemoSecondFilter do filter.");
        //对Request Response做一些预处理。
        //example设置编码格式
        servletRequest.setCharacterEncoding(GlobalConst.CHARSET_UTF8);
        servletResponse.setCharacterEncoding(GlobalConst.CHARSET_UTF8);
        log.info(((HttpServletRequest)servletRequest).getRequestURI());
        //逻辑
        //传递到下一个Filter
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("DemoSecondFilter init.");
    }
}
