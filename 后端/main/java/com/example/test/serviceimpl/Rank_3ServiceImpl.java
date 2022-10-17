package com.example.test.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.test.entity.Rank_1;
import com.example.test.entity.Rank_3;
import com.example.test.entity.RankingList;
import com.example.test.mapper.Rank_1Mapper;
import com.example.test.mapper.Rank_3Mapper;
import com.example.test.mapper.RankingListMapper;
import com.example.test.service.Rank_1Service;
import com.example.test.service.Rank_3Service;
import com.example.test.service.RankingListService;
import org.springframework.stereotype.Service;


@Service
public class Rank_3ServiceImpl extends ServiceImpl<Rank_3Mapper, Rank_3> implements Rank_3Service {


}
