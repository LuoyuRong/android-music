package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.entity.Song;
import com.example.mapper.SongMapper;
import com.example.service.SongService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Slf4j
public class SongServiceImpl extends ServiceImpl<SongMapper, Song> implements SongService {
    /**
     * 获取推荐歌曲，用户刷新返回不同的歌曲
     *
     * @return list
     */
    @Override
    public List<Song> getRecommendSong() {
        QueryWrapper<Song> wrapper = new QueryWrapper<>();
        Long count = baseMapper.selectCount(wrapper);
        log.info("Song表的总记录行数count={}", count);
        // 计算总页码
        long totalPage = (count + 30 - 1) / 30;
        Random random = new Random();
        // 生成随机页码
        int randomPage = random.nextInt((int) totalPage) + 1;
        log.info("randomPage={}", randomPage);
        Page<Song> page = new Page<>(randomPage, 30);
        // 手写SQL，数据库字段和实体属性不一致的时候需要声明别名
        wrapper.select("id", "singer_id", "name AS songName", "pic", "url");
        return baseMapper.selectPage(page, wrapper).getRecords();
    }
}
