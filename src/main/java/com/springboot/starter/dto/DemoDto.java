package com.springboot.starter.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
@Builder
public class DemoDto {
    @Value("${blog.id}")
    private Integer id;

    @Value("${blog.name}")
    private String name;
}
