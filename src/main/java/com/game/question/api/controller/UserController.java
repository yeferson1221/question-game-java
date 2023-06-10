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

    @GetMapping
    public List<User> getUser(@RequestHeader(value="Authorization") String token){
        return userService.getUser();
    }

    @PutMapping("/update/{id}")
    public User updateUser(@RequestHeader(value="Authorization") String token, @PathVariable int id, @RequestBody User user){
        user.setId(id);
        return userService.updateUserById(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@RequestHeader(value="Authorization") String token, int id){
        userService.deleteUser(id);
    }
}
