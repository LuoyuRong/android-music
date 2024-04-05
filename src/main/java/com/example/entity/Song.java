package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Song {
    /**
     * 歌曲id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 歌手id
     */
    private Integer singerId;
    /**
     * 歌曲名
     */
    @TableField(value = "name")
    private String songName;
    /**
     * 歌曲图片相对路径
     */
    private String pic;
    /**
     * 歌词
     */
    private String lyric;
    /**
     * 歌曲相对地址
     */
    private String url;

    private Date createTime;
}
