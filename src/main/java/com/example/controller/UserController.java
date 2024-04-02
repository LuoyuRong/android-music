package com.example.controller;

import com.example.R;
import com.example.entity.User;
import com.example.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/register")
    public R registerUser(@RequestBody User user) {
        return userService.userRegister(user);
    }

    /**
     * 用户登录
     *
     * @param username 用户名/手机号
     * @param password 密码
     * @return R
     */
    @PostMapping("/login")
    public R login(@RequestParam("username") String username,
                   @RequestParam("password") String password) {
        return userService.loginRequest(username, password);
    }
}