package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.RecentPlay;
import com.example.vo.SongVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecentPlayMapper extends BaseMapper<RecentPlay> {
    List<SongVo> queryRecentSong(List<Long> ids);
}
