package com.example.test.controller;



import com.example.test.entity.Rank_8;
import com.example.test.service.Rank_8Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/rank_8")
public class Rank_8Controller {

    @Autowired
    private Rank_8Service rank_8Service;

    /**
     * 查询所有
     * @return 所有图书信息
     */
    @GetMapping(value = "/select")
    public Map<String, List<Rank_8>> select() {
        Map<String, List<Rank_8>> map = new HashMap<>();
        map.put("Rank_8", rank_8Service.selectAllRank());
        return map;
    }
}
