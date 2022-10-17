package com.example.test.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.test.entity.Rank_1;
import com.example.test.entity.Rank_4;
import com.example.test.entity.RankingList;
import com.example.test.service.Rank_4Service;
import com.example.test.service.RankingListService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/4")
public class Rank_4Controller { //排行榜
    @Resource
    private Rank_4Service rank_4Service;

    //查找所有
    @GetMapping("/getAll")
    public List<Rank_4> findAll() {
        return rank_4Service.list();
    }
    @GetMapping("/page")
    public Page<Rank_4> findPage(@RequestParam Integer pageNum,
                                 @RequestParam Integer pageSize,
                                 @RequestParam(defaultValue = "") String areaname) {

        QueryWrapper<Rank_4> queryWrapper = new QueryWrapper<>();
//        queryWrapper.orderByDesc("id");//根据倒叙
        if (!"".equals(areaname)) {
            queryWrapper.like("areaname", areaname);
        }

        return rank_4Service.page(new Page<>(pageNum,pageSize),queryWrapper);
    }

}
