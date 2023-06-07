package com.game.question.api.controller;

import com.game.question.domain.Question;
import com.game.question.domain.User;
import com.game.question.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200/")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.CreateUser(user);
    }

    @GetMapping
    public List<User> getUser(){
        return userService.getUser();
    }
}
