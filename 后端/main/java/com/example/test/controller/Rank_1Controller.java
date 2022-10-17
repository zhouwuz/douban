package com.example.test.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.test.entity.Rank_1;
import com.example.test.entity.RankingList;
import com.example.test.service.Rank_1Service;
import com.example.test.service.RankingListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/1")
public class Rank_1Controller { //排行榜
    @Resource
    private Rank_1Service rank_1Service;

    //查找所有
    @GetMapping("/getAll")
    public List<Rank_1> findAll() {
        return rank_1Service.list();
    }

    @GetMapping("/page")
    public Page<Rank_1> findPage(@RequestParam Integer pageNum,
                                      @RequestParam Integer pageSize,
                                      @RequestParam(defaultValue = "") String areaname) {

        QueryWrapper<Rank_1> queryWrapper = new QueryWrapper<>();
//        queryWrapper.orderByDesc("id");//根据倒叙
        if (!"".equals(areaname)) {
            queryWrapper.like("areaname", areaname);
        }

        return rank_1Service.page(new Page<>(pageNum,pageSize),queryWrapper);
    }

}
