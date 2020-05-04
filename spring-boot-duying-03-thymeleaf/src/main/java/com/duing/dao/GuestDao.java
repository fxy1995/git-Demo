package com.duing.dao;

import com.duing.domain.Guest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 付雪缘
 * @Date 2020/5/2 11:01
 * @Version 1.0
 */
@Repository
public class GuestDao {
    //这里因为我们没有学习数据库，所以呢我们这里写固定数据
    private  static List<Guest> guestList=new ArrayList<>();
    static {
        guestList.add(new Guest("无极剑圣","战士"));
        guestList.add(new Guest("唤潮鲛机","辅助"));
        guestList.add(new Guest("诺克萨斯之手","战士"));
        guestList.add(new Guest("龙的传人","打野"));
        guestList.add(new Guest("邪恶小法师","法师"));
    }

    public  List<Guest> guestList() {
        return guestList;
    }

    public  void  add(Guest guest){
        guestList.add(guest);
    }
    public  Guest getGuestByName(String name){
        for(Guest guest:guestList){
            if (guest.getName().equals(name)){
                return guest;
            }
        }
        return new Guest();
    }
    public  void  delete(Guest guest){
        guestList.remove(guest);
    }

    public  void   update(Guest newGuest){
        //因为用户的name设计的为不可改变的所以我们通过name获取集合中的旧对象
     Guest guestold= getGuestByName(newGuest.getName());
        guestold.setRole(newGuest.getRole());
        
    }
}
