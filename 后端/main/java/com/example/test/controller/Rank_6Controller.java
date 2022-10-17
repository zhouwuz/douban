package com.example.test.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.test.entity.Rank_1;
import com.example.test.entity.Rank_6;
import com.example.test.entity.RankingList;
import com.example.test.service.Rank_2Service;
import com.example.test.service.Rank_6Service;
import com.example.test.service.RankingListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/6")
public class Rank_6Controller { //排行榜
    @Resource
    private Rank_6Service rank_6Service;

    //查找所有
    @GetMapping("/getAll")
    public List<Rank_6> findAll() {
        return rank_6Service.list();
    }
    @GetMapping("/page")
    public Page<Rank_6> findPage(@RequestParam Integer pageNum,
                                 @RequestParam Integer pageSize,
                                 @RequestParam(defaultValue = "") String year) {

        QueryWrapper<Rank_6> queryWrapper = new QueryWrapper<>();
//        queryWrapper.orderByDesc("id");//根据倒叙
        if (!"".equals(year)) {
            queryWrapper.like("year", year);
        }

        return rank_6Service.page(new Page<>(pageNum,pageSize),queryWrapper);
    }

}
