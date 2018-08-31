package com.springboot.starter.profile;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

@Profile("dev")//只有在dev配置文件激活的情况下 @Profile({"dev", "test"})
@Slf4j
@Configuration
public class ProfileBean {

    @PostConstruct //用来修饰非静态void方法，会在构造前执行
    public void init() {
        log.info("dev env active");
    }
}
