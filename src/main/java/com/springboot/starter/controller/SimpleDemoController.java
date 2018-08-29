package com.springboot.starter.controller;

import com.springboot.starter.dto.ConfigDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// @RestController = @Controller + @ResponseBody
@RestController
public class SimpleDemoController {

    @Autowired
    private ConfigDto configDto;

    @RequestMapping(value = "/simple-demo", method = RequestMethod.GET)
    public String sayHello() {
        return configDto.toString();
    }
}
