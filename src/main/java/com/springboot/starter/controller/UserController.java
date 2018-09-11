package com.springboot.starter.controller;

import com.springboot.starter.dto.UserDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/valid")
    public String userValid(@Valid UserDto user) {
        return user.toString();
    }
}
