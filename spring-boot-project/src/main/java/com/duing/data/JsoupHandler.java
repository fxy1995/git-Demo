package com.duing.data;

import com.duing.domain.DataBean;
import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.xml.xpath.XPath;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author 付雪缘
 * @Date 2020/5/28 9:10
 * @Version 1.0
 */
public class JsoupHandler {
    public static ArrayList<DataBean> getData() {
//        //写一个简单的html页面
//        String htmlStr="<html><head><title>hello Jsoup</title><body id=\"aa.properties\">我是body</body></head></html>";
//       //用来解析html页面--即html页面的字符串
//        Document doc= Jsoup.parse(htmlStr);
//        //通过标签选择器锁定任意的元素
//        Elements elements=doc.select("body");
//        //通过id选择器锁定id为xxx的元素
//        Element element=doc.getElementById("aa.properties");
////        System.out.println(doc);
////        System.out.println(element);
////        System.out.println(elements);
        //通过url直接拿到返回的html结果--如果这个返回值是html页面的话就能获取
        //通过url获取到返回结果--前提是返回结果必须是html格式的数据-《直接是html页面》-页面本身也就是字符串-只是浏览器会解析而已
        //创建一个集合用来接收返回的数据
        ArrayList<DataBean> result=new ArrayList<>();
        try {
            //获取html页面内容
            Document document = Jsoup.connect("https://ncov.dxy.cn/ncovh5/view/pneumonia").get();
           //通过id锁定元素
            Element element1=document.getElementById("getAreaStat");
           //获取标签里面的内容
            String data=element1.data();
            //观察我们需要获取的数据规则
            //这里我们需要获取[]中的内容
          String dataStr=data.substring(data.indexOf("["),data.lastIndexOf("]")+1);
            System.out.println(dataStr);
            //把json类型的字符串转换成java对象-[]对应的是ArrayList
            //这里使用Gson进行json数据的转换
            Gson gson=new Gson();
            ArrayList dataArry= gson.fromJson(dataStr,ArrayList.class);
            System.out.println(dataArry);
            for (int i=0;i<dataArry.size();i++){
                Map map=(Map)dataArry.get(i);
             String name=(String) map.get("provinceName");//省名
             double nowConfirm=(double)map.get("currentConfirmedCount");//现存确诊
             double confirm=(double)map.get("confirmedCount");//累计确诊
             double heal=(double)map.get("curedCount");//治愈
             double dead=(double)map.get("deadCount");//死亡
                //把数据构建成domain对象
         DataBean dataBean=new DataBean(null,name,(int)confirm,(int)dead,(int)heal,(int)nowConfirm);
         //把domain对象加入集合中返回
                result.add(dataBean);
            }
        }catch (Exception e){

        }
        System.out.println(result);
        return result;
    }
    public static void main(String[] args) {
        ArrayList arrayList=JsoupHandler.getData();
        System.out.println(arrayList);
    }
}
