package org.sample.spring_security_demo.controller;

import org.sample.spring_security_demo.dto.UserDto;
import org.sample.spring_security_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    UserService service;

    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@RequestBody UserDto input) {
        return service.signup(input);
    }


}
