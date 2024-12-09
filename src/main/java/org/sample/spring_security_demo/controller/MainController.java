package org.sample.spring_security_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    
    @GetMapping("/home-user")
    public String homeUser(){
        return "User Home Page Loaded Success";
    }

    @GetMapping("/home-admin")
    public String home(){
        return "Admin Home Page Loaded Success";
    }
}
