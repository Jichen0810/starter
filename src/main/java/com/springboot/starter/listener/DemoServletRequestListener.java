package com.springboot.starter.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
@Slf4j
public class DemoServletRequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }
}
