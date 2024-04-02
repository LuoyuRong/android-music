package com.example.controller;

import com.example.entity.Song;
import com.example.service.SongService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class SongController {
    @Resource
    private SongService songService;

    /**
     * 获取推荐歌曲
     *
     * @return list
     */
    @GetMapping("/recommend/song")
    public List<Song> getSongTop30() {
        return songService.getRecommendSong();
    }
}
