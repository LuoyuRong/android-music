package com.example.entity;

import lombok.Data;

@Data
public class Song {
    private Long id;
    private String singer;
    private String songName;
    private String pic; // 图片地址
    private String lyric; //作曲
    private String url; //歌曲地址
}
