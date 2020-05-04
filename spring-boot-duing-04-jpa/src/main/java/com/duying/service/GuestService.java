package com.duying.service;

import com.duying.domain.Guest;
import com.duying.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 付雪缘
 * @Date 2020/5/4 15:57
 * @Version 1.0
 */
public interface GuestService   {

   List<Guest> list();
}
