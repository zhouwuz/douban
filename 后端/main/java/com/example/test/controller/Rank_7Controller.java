package com.example.test.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.test.entity.Rank_1;
import com.example.test.entity.Rank_6;
import com.example.test.entity.Rank_7;
import com.example.test.entity.RankingList;
import com.example.test.service.Rank_6Service;
import com.example.test.service.Rank_7Service;
import com.example.test.service.RankingListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/7")
public class Rank_7Controller { //排行榜
    @Resource
    private Rank_7Service rank_7Service;

    //查找所有
    @GetMapping("/getAll")
    public List<Rank_7> findAll() {
        return rank_7Service.list();
    }

    @GetMapping("/page")
    public Page<Rank_7> findPage(@RequestParam Integer pageNum,
                                 @RequestParam Integer pageSize,
                                 @RequestParam(defaultValue = "") String areaname) {

        QueryWrapper<Rank_7> queryWrapper = new QueryWrapper<>();
//        queryWrapper.orderByDesc("id");//根据倒叙
        if (!"".equals(areaname)) {
            queryWrapper.like("areaname", areaname);
        }

        return rank_7Service.page(new Page<>(pageNum,pageSize),queryWrapper);
    }
}
