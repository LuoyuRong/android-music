package com.example.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

@Data
public class SongVo {
    private Long id;
    @TableField(value = "name")
    private Long songId;
    private String songName;
    private String pic;
    private String url;
    private Integer isCollect;
    private Integer count;
    private Date playTime;
}
