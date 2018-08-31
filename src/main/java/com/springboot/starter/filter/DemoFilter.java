package com.springboot.starter.filter;

import com.springboot.starter.consts.GlobalConst;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

//@WebFilter(filterName = "DemoFilter", urlPatterns = UrlPatternConst.ALL_URL) //@WebFilter后省去了在web.xml中配置Filter的工作
@Slf4j
public class DemoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //可以通过FilterConfig获取WebApplicationContext，存放所有的controller bean的上下文，方法如下
        //filterConfig.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        log.info("DemoFilter init.");
    }

    @Override
    public void destroy() {
        log.info("DemoFilter destroy.");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("DemoFilter do filter.");
        //对Request Response做一些预处理。
        //example设置编码格式
        servletRequest.setCharacterEncoding(GlobalConst.CHARSET_UTF8);
        servletResponse.setCharacterEncoding(GlobalConst.CHARSET_UTF8);
        //逻辑
        //传递到下一个Filter
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
