package com.gms.blogapp.controller;

import com.gms.blogapp.Repository.UserRepository;
import com.gms.blogapp.entity.User;
import com.gms.blogapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody User user){
        return userService.login(user);
    }
    @PostMapping("register")
    public ResponseEntity<User> register(@RequestBody User user){
        return userService.register(user);
    }

    public ResponseEntity<String> changePassword(@RequestBody User user){
        return userService.changePassword(user);
    }
    @GetMapping("get-bookmarks")
    public User getAllBookmarks(@RequestParam int userId){
        return userService.getAllBookmarks(userId);
    }
}
