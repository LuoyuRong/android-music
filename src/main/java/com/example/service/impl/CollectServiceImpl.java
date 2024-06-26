package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.R;
import com.example.entity.Collect;
import com.example.entity.Song;
import com.example.mapper.CollectMapper;
import com.example.mapper.SongMapper;
import com.example.service.CollectService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements CollectService {
    @Resource
    private SongMapper songMapper;

    @Override
    public R judgeCollect(Collect collect) {
        Collect result = baseMapper.selectOne(new QueryWrapper<Collect>()
                .eq("user_id", collect.getUserId())
                .eq("song_id", collect.getSongId()));
        log.info("result={}", result);
        // 1. 查不到数据说明没有收藏
        if (Objects.isNull(result)) {
            collect.setCreateTime(new Date());
            baseMapper.insert(collect);
            return R.success(Boolean.TRUE, "已添加到我喜欢");
        }
        baseMapper.deleteById(result.getId());
        return R.success(Boolean.FALSE, "已取消收藏");
    }

    /**
     * 查询用户收藏的歌曲
     *
     * @param userId 用户id
     * @return 歌曲list
     */
    @Override
    public List<Song> queryCollectSong(Long userId) {
        log.info("入参-userId={}", userId);
        List<Collect> ids = list(new QueryWrapper<Collect>().eq("user_id", userId).orderByDesc("create_time"));
        // 获取歌曲id集合
        List<Long> songIds = ids.stream().map(Collect::getSongId).toList();
        if (songIds.isEmpty()) {
            return new ArrayList<>();
        }
        log.info("收藏歌曲的ids={}", songIds);
        return songMapper.queryCollectSong(songIds);
    }
}
