package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class RecentPlay {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Long userId;
    private Long songId;
    private Integer isCollect;
    private Integer count;
    private Date playTime;
    private Date createTime;
}
