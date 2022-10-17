package com.example.test.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.test.entity.Rank_1;
import com.example.test.entity.RankingList;
import com.example.test.mapper.Rank_1Mapper;
import com.example.test.mapper.RankingListMapper;
import com.example.test.service.Rank_1Service;
import com.example.test.service.RankingListService;
import org.springframework.stereotype.Service;


@Service
public class Rank_1ServiceImpl extends ServiceImpl<Rank_1Mapper, Rank_1> implements Rank_1Service{


}
