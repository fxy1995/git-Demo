package com.duing.servece;

import com.duing.domain.Guest;

import java.util.List;

/**
 * @Author 付雪缘
 * @Date 2020/5/2 10:58
 * @Version 1.0
 */
public interface GuestService {
    List<Guest> list();
    void add(Guest guest);
    Guest getGuestByName(String name);
    void delete(Guest guest);
    void update(Guest guest);
}
