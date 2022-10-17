package com.example.test.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.test.entity.Rank_1;
import com.example.test.entity.Rank_3;
import com.example.test.entity.RankingList;
import com.example.test.service.Rank_3Service;
import com.example.test.service.RankingListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/3")
public class Rank_3Controller { //排行榜
    @Resource
    private Rank_3Service rank_3Service;

    //查找所有
    @GetMapping("/getAll")
    public List<Rank_3> findAll() {
        return rank_3Service.list();
    }
    @GetMapping("/page")
    public Page<Rank_3> findPage(@RequestParam Integer pageNum,
                                 @RequestParam Integer pageSize,
                                 @RequestParam(defaultValue = "") String score) {

        QueryWrapper<Rank_3> queryWrapper = new QueryWrapper<>();
//        queryWrapper.orderByDesc("id");//根据倒叙
        if (!"".equals(score)) {
            queryWrapper.like("score", score);
        }

        return rank_3Service.page(new Page<>(pageNum,pageSize),queryWrapper);
    }
}
