package com.example.test.serviceimpl;

import cn.hutool.log.Log;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.test.dao.Rank_5VO;
import com.example.test.dao.DataVO;
import com.example.test.entity.Rank_5;
import com.example.test.mapper.Rank_5Mapper;

import com.example.test.service.Rank_5Service;
import com.example.test.utils.DataUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Rank_5ServiceImpl extends ServiceImpl<Rank_5Mapper, Rank_5> implements Rank_5Service {

    @Autowired
    private Rank_5Mapper rank_5Mapper;
    @Override
    public Rank_5VO select() {

        Rank_5VO rank_5VO = new Rank_5VO();
        List<String> years = new ArrayList<>();
        List<DataVO> nums = new ArrayList<>();


        /*先查出数据，
         **/
        List<Rank_5> rank_5List = this.rank_5Mapper.selectList(null);
        for (Rank_5 rank_5 : rank_5List) {
            years.add(rank_5.getYear());
            DataVO dataVO=new DataVO();
            dataVO.setValue(rank_5.getNum());
            /*Map<String,String> map=new HashMap<>();
            map.put("color","000000");*/
            dataVO.setItemStyle(DataUtil.createItemStyle(rank_5.getNum()));
            /*dataVO.setItemStyle(map);*/
            nums.add(dataVO);
        }
        rank_5VO.setYear(years);
        rank_5VO.setNum(nums);

        /* 再转换vo */
        return rank_5VO;
    }
}
