package com.springboot.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = "classpath:my.properties", encoding = "utf-8")
@SpringBootApplication //=@SpringBootConfiguration + @EnableAutoConfiguration + @ComponentScan
@ServletComponentScan //开启Filter的扫描
public class StarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarterApplication.class, args);
    }
}
