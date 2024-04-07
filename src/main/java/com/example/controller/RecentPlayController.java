package com.example.controller;

import com.example.service.RecentPlayService;
import com.example.vo.SongVo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecentPlayController {
    @Resource
    private RecentPlayService playSongService;

    @GetMapping("/recent")
    public void addOrUpdate(@RequestParam("userId") Long userId,
                       @RequestParam("songId") Long songId) {
        playSongService.addOrUpdate(userId, songId);
    }

    @GetMapping("/query/recent")
    public List<SongVo> queryRecentSong(@RequestParam("userId") Long userId) {
        return playSongService.queryRecentSong(userId);
    }
}
