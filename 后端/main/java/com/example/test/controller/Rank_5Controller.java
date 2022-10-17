package com.example.test.controller;

import com.example.test.dao.Rank_5VO;
import com.example.test.service.Rank_5Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rank_5")
public class Rank_5Controller {
    @Autowired
    private Rank_5Service rank_5Service;

    @GetMapping("/select")
    public Rank_5VO barVO() {
        return this.rank_5Service.select();
    }
}
