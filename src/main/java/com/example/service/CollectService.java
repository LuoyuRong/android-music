package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.R;
import com.example.entity.Collect;
import com.example.entity.Song;

import java.util.List;

public interface CollectService extends IService<Collect> {
    R judgeCollect(Collect collect);

    List<Song> queryCollectSong(Long userId);
}
