package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Song;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SongMapper extends BaseMapper<Song> {

    /**
     * 查询收藏的歌曲，按照收藏时间排序
     *
     * @param ids 歌曲id
     * @return 收藏的歌曲列表
     */
    List<Song> queryCollectSong(@Param("ids") List<Long> ids);
}
