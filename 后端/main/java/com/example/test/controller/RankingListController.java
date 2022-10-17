package com.example.test.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.test.entity.RankingList;

import com.example.test.service.RankingListService;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/paihang")
public class RankingListController { //排行榜
    @Resource
    private RankingListService rankingListService;

    //查找所有
    @GetMapping("/getAll")
    public List<RankingList> findAll() {
        return rankingListService.list();
    }

    //搜索并显示一页
    @GetMapping("/page")
    public Page<RankingList> findPage(@RequestParam Integer pageNum,
                               @RequestParam Integer pageSize,
                               @RequestParam(defaultValue = "") String name) {

        QueryWrapper<RankingList> queryWrapper = new QueryWrapper<>();
//        queryWrapper.orderByDesc("id");//根据倒叙
        if (!"".equals(name)) {
            queryWrapper.like("name", name);
        }

        return rankingListService.page(new Page<>(pageNum,pageSize),queryWrapper);
    }
}
