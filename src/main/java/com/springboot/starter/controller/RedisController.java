package com.springboot.starter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "/redis")
public class RedisController {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping(value = "/set/{key}/{value}")
    public String set(@PathVariable("key") String key, @PathVariable("value") String value) {
        redisTemplate.opsForValue().set(key, value);
        return "Set key:" + key + ", value: " + value;
    }

    @GetMapping(value = "/get/{key}")
    public String get(@PathVariable("key") String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
