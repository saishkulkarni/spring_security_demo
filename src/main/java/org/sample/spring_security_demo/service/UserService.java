package org.sample.spring_security_demo.service;

import java.util.HashMap;
import java.util.Map;

import org.sample.spring_security_demo.dto.UserDto;
import org.sample.spring_security_demo.entity.User;
import org.sample.spring_security_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository repository;

    public ResponseEntity<Object> signup(UserDto input) {
        if (input == null || input.getEmail() == null || input.getPassword() == null) {
            Map<String, String> map = new HashMap<>();
            map.put("message", "Invalid input data");
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }

        if (repository.existsByEmail(input.getEmail())) {
            Map<String, String> map = new HashMap<>();
            map.put("message", "Email Already Exists");
            return new ResponseEntity<>(map, HttpStatus.UNPROCESSABLE_ENTITY);
        }

        input.setPassword(encoder.encode(input.getPassword()));
        repository.save(new User(input));
        
        Map<String, String> map = new HashMap<>();
        map.put("message", "User Created Successfully");
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }
}
