package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.entity.Song;
import com.example.service.SongService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class SongController {
    @Resource
    private SongService songService;

    /**
     * 模糊查询歌曲
     * @param songName 歌名
     * @return list
     */
    @GetMapping("/song")
    public List<Song> getSong(@RequestParam("songName") String songName) {
        log.info("入参-{}", songName);
        QueryWrapper<Song> wrapper = new QueryWrapper<>();
        wrapper.like("introduction", songName);
        return songService.list(wrapper);
    }

    @GetMapping
    public List<Song> getAllSong() {
        return songService.list();
    }
}
