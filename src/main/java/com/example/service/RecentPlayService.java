package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.entity.RecentPlay;
import com.example.vo.SongVo;

import java.util.List;

public interface RecentPlayService extends IService<RecentPlay> {
    void addOrUpdate(Long userId, Long songId);

    List<SongVo> queryRecentSong(Long userId);
}
