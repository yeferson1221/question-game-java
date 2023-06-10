package com.game.question.api.controller;

import com.game.question.domain.User;
import com.game.question.repository.UserRepository;
import com.game.question.service.UserService;
import com.game.question.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin("http://localhost:4200/")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody User user) {
        User authenticatedUser = userService.idCredential(user.getEmail(), user.getPassword());

        if (authenticatedUser != null) {
            String tokenJwt = jwtUtil.create(String.valueOf(authenticatedUser.getId()), authenticatedUser.getEmail());
            return ResponseEntity.ok(tokenJwt);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

}
