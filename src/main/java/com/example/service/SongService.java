package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.Song;

import java.util.List;

public interface SongService extends IService<Song> {
    List<Song> getRecommendSong();
}
