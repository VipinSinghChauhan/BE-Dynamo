package com.dynamo.dynamoapp.controller;

import com.dynamo.dynamoapp.entity.UserInfo;
import com.dynamo.dynamoapp.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserInfoRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/")
    public UserInfo saveUser(@RequestBody UserInfo user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public UserInfo getUser(@PathVariable("id") long id) {
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("User Not found"));
    }

    @GetMapping("/")
    public List<UserInfo> getAllUsers() {
        return userRepository.findAll();
    }
}
