package com.example;

import com.example.entity.User;
import com.example.service.UserService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
@Slf4j
class AndroidMusicApplicationTests {
    @Resource
    private UserService userService;
    @Test
    void contextLoads() {
        User user = new User();
        user.setUsername("aaa");
        user.setPassword("111");
        user.setPhoneNumber("13121");
        boolean save = userService.save(user);
        log.info("" + save);
    }

}
