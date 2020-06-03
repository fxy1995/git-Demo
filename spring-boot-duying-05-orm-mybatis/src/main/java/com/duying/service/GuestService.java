package com.duying.service;

import com.duying.domain.Guest;
import com.duying.mapper.GuestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 付雪缘
 * @Date 2020/5/4 17:15
 * @Version 1.0
 */
@Service
public class GuestService {
  @Autowired
  private GuestMapper guestMapper;
    public List<Guest> selectGuests(){
        return  guestMapper.selectGuests();
    }
}
