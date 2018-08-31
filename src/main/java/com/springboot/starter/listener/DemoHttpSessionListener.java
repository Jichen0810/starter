package com.springboot.starter.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 统计在线人数，使用的Synchronized关键字，可优化
 */
@WebListener
@Slf4j
public class DemoHttpSessionListener implements HttpSessionListener {
    private int count = 0;
    private final static String SESSION_COUNT = "count";

    @Override
    public synchronized void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        log.info("Session destroyed.");
        count--;
        HttpSession httpSession = httpSessionEvent.getSession();
        ServletContext servletContext = httpSession.getServletContext();
        servletContext.setAttribute(SESSION_COUNT, count);
    }

    @Override
    public synchronized void sessionCreated(HttpSessionEvent httpSessionEvent) {
        log.info("Session created.");
        count++;
        HttpSession httpSession = httpSessionEvent.getSession();
        ServletContext servletContext = httpSession.getServletContext();
        servletContext.setAttribute(SESSION_COUNT, count);
    }
}
