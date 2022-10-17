package com.example.test.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.test.entity.Rank_1;
import com.example.test.entity.Rank_2;
import com.example.test.entity.RankingList;
import com.example.test.service.Rank_2Service;
import com.example.test.service.RankingListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/2")
public class Rank_2Controller { //排行榜
    @Resource
    private Rank_2Service rank_2Service;

    //查找所有
    @GetMapping("/getAll")
    public List<Rank_2> findAll() {
        return rank_2Service.list();
    }
    @GetMapping("/page")
    public Page<Rank_2> findPage(@RequestParam Integer pageNum,
                                 @RequestParam Integer pageSize,
                                 @RequestParam(defaultValue = "") String areaname) {

        QueryWrapper<Rank_2> queryWrapper = new QueryWrapper<>();
//        queryWrapper.orderByDesc("id");//根据倒叙
        if (!"".equals(areaname)) {
            queryWrapper.like("areaname", areaname);
        }

        return rank_2Service.page(new Page<>(pageNum,pageSize),queryWrapper);
    }

}
