package com.duing.service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duing.domain.Guest;
import com.duing.plus.mapper.GuestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author 付雪缘
 * @Date 2020/5/5 17:56
 * @Version 1.0
 */
//@Service
//public class GusetServiceImp implements GuestService {
//
//    //使用tk.mybatis
////这里给Mapper自动注入就可以使用mapper中继承自系统得方法咯
////    @Autowired
////   private GuestMapper guestMapper;
////    @Override
////    public List<Guest> getGuestAll() {
////        return guestMapper.selectAll();
////    }
//    //使用mybatis-plus
//    @Autowired
//    private GuestMapper guestMapper;
//    @Override
//    public List<Guest> getGuestAll() {
//        //参数我们还需要所以先写成null
//      return guestMapper.selectList(null);
//
//    }
    //这里展示mybatis-plus 和jpa and tk.mybatis不同之处
@Service                //继承系统类 ServiceImpl<对应的mapper，domain类 > 实现 自定义得接口 自定义接口也需要继承一个系统接口
public class GusetServiceImp extends ServiceImpl<GuestMapper,Guest> implements GuestService{
//当 mybatis-plus 得domain 和service 都配置好之后，service 也不用写方法了
    //和jpa and tk.mybatis 功能不同的地方就是简化了 service 层

}
