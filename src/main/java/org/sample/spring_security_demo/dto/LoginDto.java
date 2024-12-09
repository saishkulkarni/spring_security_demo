package org.sample.spring_security_demo.dto;

import lombok.Data;

@Data
public class LoginDto {
    private String email;
    private String password;
}
