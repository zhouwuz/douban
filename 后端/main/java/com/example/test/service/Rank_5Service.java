package com.example.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.test.dao.Rank_5VO;
import com.example.test.entity.Rank_5;

public interface Rank_5Service extends IService<Rank_5> {
    public Rank_5VO select();
}
