package com.duing.service;

import com.duing.domain.Guest;
import com.duing.mapperTwo.GuestMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author 付雪缘
 * @Date 2020/5/6 7:16
 * @Version 1.0
 */
@Service
public class GuestService {
    //这是第一套方案
//  @Autowired
//  private  GuestMapper guestMapper;
    //这是第二套方案  注意方案一和方案二的GuestMapper对象是不同包下的
   @Autowired
    private GuestMapper2 guestMapper2;
    public List<Guest> getAll(){
        return guestMapper2.getAll();
    }
    public  void  add(Guest guest){
        guestMapper2.add(guest);
    }
}
