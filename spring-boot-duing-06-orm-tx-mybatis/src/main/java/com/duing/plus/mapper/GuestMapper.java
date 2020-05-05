package com.duing.plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.duing.domain.Guest;

/**
 * @Author 付雪缘
 * @Date 2020/5/5 19:06
 * @Version 1.0
 */
//我们使用Mybatis-plus插件时mapper接口需要继承BaseMapper接口泛型为domain
public interface GuestMapper extends BaseMapper<Guest> {
}
