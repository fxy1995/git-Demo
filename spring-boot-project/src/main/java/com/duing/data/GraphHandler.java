package com.duing.data;

import com.duing.domain.GraphDataBean;
import com.duing.util.HttpClientUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Map;

/**
 * @Author 付雪缘
 * @Date 2020/5/30 17:13
 * @Version 1.0
 */
//折线图展示
public class GraphHandler {
    private static final String url="https://view.inews.qq.com/g2/getOnsInfo?name=disease_other";
    public static ArrayList getData(){
        String resultStr= HttpClientUtil.doGet(url);
        Gson gson=new Gson();
        Map map=gson.fromJson(resultStr,Map.class);
       String dataStr=(String) map.get("data");
       Map dataMap=gson.fromJson(dataStr,Map.class);
      ArrayList list=(ArrayList) dataMap.get("chinaDayList");
      ArrayList<GraphDataBean> result=new ArrayList<>();
      for (int i=1;i<list.size();i++){
          Map chinaDayMap=(Map) list.get(i);

          String date=(String) chinaDayMap.get("date");
          double confirm=(double)chinaDayMap.get("confirm");//累计确诊
          double dead=(double)chinaDayMap.get("dead");//累计死亡
          double heal=(double)chinaDayMap.get("heal");//累计治愈
          GraphDataBean graphDataBean=new GraphDataBean(date,(int)confirm,(int)dead,(int)heal);
      result.add(graphDataBean);
      }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        GraphHandler.getData();
    }
}
