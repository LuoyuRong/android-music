package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.R;
import com.example.entity.User;

public interface UserService extends IService<User> {
    R userRegister(User user);

    R loginRequest(String account, String password);

    R logoffRequest(Long userId);
}
