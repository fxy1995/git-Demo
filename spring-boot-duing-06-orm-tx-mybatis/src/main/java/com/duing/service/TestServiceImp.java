package com.duing.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duing.domain.Guest;
import com.duing.plus.mapper.TestMapper;
import org.springframework.stereotype.Service;

/**
 * @Author 付雪缘
 * @Date 2020/5/28 12:29
 * @Version 1.0
 */
@Service
public class TestServiceImp extends ServiceImpl<TestMapper, Guest> implements TestService{
}
