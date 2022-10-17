package com.example.test.serviceimpl;

import cn.hutool.log.Log;
import com.example.test.entity.Rank_8;
import com.example.test.mapper.Rank_8Mapper;
import com.example.test.service.Rank_8Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Rank_8ServiceImpl implements Rank_8Service {

    @Autowired
    private Rank_8Mapper rank_8Mapper;

    @Override
    public List<Rank_8> selectAllRank() {
        return rank_8Mapper.findAll();
    }

}
