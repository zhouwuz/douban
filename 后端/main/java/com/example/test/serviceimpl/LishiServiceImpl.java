package com.example.test.serviceimpl;

import cn.hutool.log.Log;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.test.entity.Lishi;
import com.example.test.mapper.LishiMapper;
import com.example.test.service.LishiService;
import org.springframework.stereotype.Service;

@Service
public class LishiServiceImpl extends ServiceImpl<LishiMapper, Lishi> implements LishiService {



}
