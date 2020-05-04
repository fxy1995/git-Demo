package com.duing.servece;

import com.duing.dao.GuestDao;
import com.duing.domain.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 付雪缘
 * @Date 2020/5/2 11:00
 * @Version 1.0
 */
@Service
public class GuestServiceImp implements GuestService {
@Autowired
private GuestDao guestDao;
    @Override
    public List<Guest> list() {
        return guestDao.guestList();
    }

    @Override
    public void add(Guest guest) {
        guestDao.add(guest);
    }

    @Override
    public Guest getGuestByName(String name) {
        return guestDao.getGuestByName(name);
    }

    @Override
    public void delete(Guest guest) {
        guestDao.delete(guest);
    }

    @Override
    public void update(Guest guest) {
        guestDao.update(guest);
    }

}
