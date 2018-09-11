package com.springboot.starter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @NotBlank(message = "Name不能为空")
    private String name;

    @Length(max = 10, message = "Code长度不能超过10")
    private String Code;
}
