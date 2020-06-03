package com.duing.data;

import com.duing.domain.DataBean;
import com.duing.service.DataService;
import com.duing.util.HttpURLConnectionUtil;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.*;
/**
 * @Author 付雪缘
 * @Date 2020/5/18 12:06
 * @Version 1.0
 */
//这个类交给Spring管理
 @Component
public class DataHandler {
public  static String url="https://view.inews.qq.com/g2/getOnsInfo?name=disease_h5";
//因为我们要把得到的数据初始化到数据库-所以需要service层
    @Autowired
    public DataService dataService;
//这个方法用来在项目启动时-把数据更新到数据库中进行一次初话--
// 注意，这个方法在项目启动时初始化，增加了效率，只会执行一次，非常实用
//当方法上加上这个注解后，系统就会在自定注入之后，servlet运行时执行这个方法
@PostConstruct//初始化数据的注解
public  void initData(){
//    首先我们需要把数据库中的旧数据删除-因为我们每启动一次项目，就会添加一次数据
//            在添加数据时，我们需要把数据库中的旧数据删除
dataService.remove(null);//表示删除所有数据
    List<DataBean> dataList=getData();//调用静态方法获取所有数据
dataService.saveBatch(dataList);//把集合中的数都添加到数据库中
}
//定时更新任务-首先需要在启动类上加上注解表示我们要使用定时任务加注解@EnableScheduling
    //在定时任务方法上加
    //方式一 @Scheduled(cron ="写cron表达式-定义多少时间执行一次任务，用在线工具生成表达式" )
    /**方式二 @Scheduled(fixedRate =10000 )值时毫秒值-表示当每10000毫秒执行一次
           注意：fixedRate是当方法开始执行就计算间隔时间-如果这个方法需要执行15秒，而定时间隔是10秒，那么方法执行完，会立即执行定时任务*/
    /** 方式三
     *@Scheduled(fixedDelay = 10000)//方法执行完毕后才开始算时间
     * */

//  @Scheduled(cron ="0/10 * * * * ? " )我这个表达式表示每10秒执行一次
 //   @Scheduled(fixedRate =10000 )//方法开始执行时就开始计算间隔时间了
    @Scheduled(fixedDelay = 200000000)//方法执行完毕后才开始算时间
    public  void  scheduledUpdate() throws InterruptedException {
      //因为这个任务间隔自定义时间后就会执行所以
        //1.删除之前表中的所有旧数据
        dataService.remove(null);
        //2.调用我们自己写好的静态方法获取新数据
           List<DataBean> dataList= getData();
           //3.把新数据添加到数据库中
        dataService.saveBatch(dataList);
    }
//这个方法用来获取数据
public static   ArrayList<DataBean> getData(){
    String str= HttpURLConnectionUtil.doGet(url);
      Gson gson=new Gson();
      Map map=gson.fromJson(str, Map.class);
     // 此时map中有两个值-注意data得value值是字符串并不是json数据
    //把data字符串再进行处理成json
    String subStr=(String) map.get("data");
    Map dataMap=gson.fromJson(subStr,Map.class);
        //获取所有国家的疫情信息
   ArrayList    areaList =(ArrayList)dataMap.get("areaTree");
        System.out.println(areaList);
        //获取中国的疫情信息
     LinkedTreeMap chinaMap=(LinkedTreeMap) areaList.get(0);
       System.out.println(chinaMap);
       ArrayList<DataBean> result=new ArrayList<>();
 ArrayList city=(ArrayList) chinaMap.get("children");
        System.out.println(city);
        for (int i=0;i<city.size();i++){
            Map cityMap=(Map) city.get(i);
           String name=(String) cityMap.get("name");
           Map totalMap=(Map) cityMap.get("total");
           double confirm=(double)totalMap.get("confirm");//累计确诊
           double heal=(double)totalMap.get("heal");//治愈
          double dead=(double)totalMap.get("dead");//死亡
          double nowConfirm=(double)totalMap.get("nowConfirm"); //现有确诊
          DataBean dataBean=new DataBean(null,name,(int)confirm,(int)dead,(int)heal,(int)nowConfirm);
          result.add(dataBean);
        }
       return result;
    }

}