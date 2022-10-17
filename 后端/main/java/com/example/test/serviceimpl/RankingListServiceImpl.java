package com.example.test.serviceimpl;

import cn.hutool.log.Log;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.test.entity.RankingList;

import com.example.test.mapper.RankingListMapper;


import com.example.test.service.RankingListService;
import org.springframework.stereotype.Service;



@Service
public class RankingListServiceImpl extends ServiceImpl<RankingListMapper, RankingList> implements RankingListService {


}
