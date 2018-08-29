package com.springboot.starter.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@Builder
@ConfigurationProperties(prefix = "config")
public class ConfigDto {
    private String code;
    private String name;
    private List<String> hobby;
}
