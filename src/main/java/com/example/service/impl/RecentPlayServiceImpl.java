package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Collect;
import com.example.entity.RecentPlay;
import com.example.mapper.CollectMapper;
import com.example.mapper.RecentPlayMapper;
import com.example.service.RecentPlayService;
import com.example.vo.SongVo;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class RecentPlayServiceImpl extends ServiceImpl<RecentPlayMapper, RecentPlay> implements RecentPlayService {
    @Resource
    private CollectMapper collectMapper;

    @Override
    public void addOrUpdate(Long userId, Long songId) {
        // 查询该歌曲是否播放过。播放过则进行更新操作，首次播放则执行插入操作
        RecentPlay result = baseMapper.selectOne(new QueryWrapper<RecentPlay>()
                .eq("user_id", userId)
                .eq("song_id", songId));
        Collect collect = collectMapper.selectOne(new QueryWrapper<Collect>()
                .eq("user_id", userId)
                .eq("song_id", songId));
        RecentPlay playSong = new RecentPlay();
        // 收藏歌曲置为 1
        if (collect != null && result != null) {
            result.setIsCollect(1);
        }
        // 插入操作
        if (result == null) {
            playSong.setUserId(userId);
            playSong.setSongId(songId);
            playSong.setCount(1);
            if (collect != null) {
                playSong.setIsCollect(1);
            }
            playSong.setPlayTime(new Date());
            playSong.setCreateTime(new Date());
            baseMapper.insert(playSong);
        } else {
            // 更新操作
            // count + 1
            Objects.requireNonNull(result).setCount(result.getCount() + 1);
            result.setPlayTime(new Date());
            baseMapper.updateById(result);
        }
    }

    @Override
    public List<SongVo> queryRecentSong(Long userId) {
        List<RecentPlay> ids = list(new QueryWrapper<RecentPlay>().eq("user_id", userId));
        List<Long> songIds = ids.stream().map(RecentPlay::getSongId).toList();
        if (songIds.isEmpty()) {
            return new ArrayList<>();
        }
        return baseMapper.queryRecentSong(songIds);
    }
}
