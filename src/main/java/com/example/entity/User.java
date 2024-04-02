package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {
    /**
     * 用户id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户名/昵称
     */
    private String username;
    /**
     * 用户手机号
     */
    private String phoneNumber;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 生日
     */
    @TableField(value = "birth")
    private String birthday;
    /**
     * 性别
     */
    private Byte gender;
    /**
     *
     */
    private String updatedTime;
    /**
     * 创建时间
     */
    private String createdTime;
}
