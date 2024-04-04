package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.R;
import com.example.entity.Collect;
import com.example.entity.Song;
import com.example.service.CollectService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class CollectController {
    @Resource
    private CollectService collectService;

    /**
     * 根据用户id查询用户收藏的歌曲信息
     *
     * @param userId 用户id
     * @return 收藏信息list
     */
    @GetMapping("/collect/user")
    public List<Song> getCollectOfUser(@RequestParam("userId") long userId) {
        return collectService.queryCollectSong(userId);

    }

    /**
     * 判断歌曲是否已收藏
     *
     * @param collect 收藏信息
     * @return R
     */
    @PostMapping("/collect/judge")
    public R judgeIsCollect(@RequestBody Collect collect) {
        return collectService.judgeCollect(collect);
    }

    /**
     * 判断歌曲是否已收藏
     *
     * @param collect 收藏信息
     * @return R
     */
    @PostMapping("/collect/status")
    public R queryCollect(@RequestBody Collect collect) {
        return R.success(collectService.getOne(new QueryWrapper<Collect>()
                .eq("user_id", collect.getUserId())
                .eq("song_id", collect.getSongId())), "");
    }
}
