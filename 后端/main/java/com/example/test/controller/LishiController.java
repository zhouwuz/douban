package com.example.test.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.test.entity.Lishi;

import com.example.test.service.LishiService;


import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/lishi")
public class LishiController { //排行榜
    @Resource
    private LishiService lishiService;

    //查找所有
    @GetMapping("/getAll")
    public List<Lishi> findAll() {
        return lishiService.list();
    }

    //搜索并显示一页
    @GetMapping("/page")
    public Page<Lishi> findPage(@RequestParam Integer pageNum,
                                      @RequestParam Integer pageSize,
                                      @RequestParam(defaultValue = "") String account) {

        QueryWrapper<Lishi> queryWrapper = new QueryWrapper<>();
//        queryWrapper.orderByDesc("id");//根据倒叙
        if (!"".equals(account)) {
            queryWrapper.like("account", account);
        }

        return lishiService.page(new Page<>(pageNum,pageSize),queryWrapper);
    }
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Integer id) {
        return lishiService.removeById(id);
    }
}

