package org.sample.spring_security_demo.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class UserDto {
    private String username;
    private String email;
    private String password;
    private String role;
}
