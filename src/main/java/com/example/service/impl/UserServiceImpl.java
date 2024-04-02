package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.R;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Override
    public R userRegister(User user) {
        user.setCreatedTime(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
        user.setUpdatedTime(DateFormatUtils.format(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss"));
        R r = new R();
        try {
            save(user);
            r.setSuccess(true);
            r.setMessage("恭喜你,注册成功!");
            r.setCode(200);
        } catch (Exception e) {
            r.setSuccess(false);
            r.setCode(500);
            r.setMessage("注册失败,用户名已存在!");
            log.info("{}", "0000");
        }
        return r;
    }

    @Override
    public R loginRequest(String account, String password) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", account).or().eq("phone_number", account);
        User user;
        try {
            user = baseMapper.selectOne(wrapper);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (user == null) {
            return R.error("未查询到用户!请您先注册");
        }
        if (!Objects.equals(user.getUsername(), account)
                || !Objects.equals(user.getPhoneNumber(), account)
                && !Objects.equals(user.getPassword(), password)) {
            return R.error("登录失败! 密码输入错误!");
        }
        return R.success(user, "登录成功!");
    }
}
