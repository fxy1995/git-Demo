package com.duing.util;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author 付雪缘
 * @Date 2020/5/27 16:54
 * @Version 1.0
 */
public class HttpURLConnectionUtil {
    public static String doGet(String urlStr){
        HttpURLConnection conn=null;
        //这两个流是用来读取读取网络请求得数据-在try外边声明是因为我们需要关闭流-在finally中关闭
        //网路字节流
        InputStream is=null;
        //网络字符缓冲流
        BufferedReader br=null;
        //做最终数据的接收
        StringBuilder result=new StringBuilder();
        try {
            //创建远程URL对象
          URL url=new URL(urlStr);
            //通过远程对象打开链接
            conn=(HttpURLConnection) url.openConnection();
            //设置请求类型
            conn.setRequestMethod("GET");
            //设置连接的超时时间和读取的超时时间--开发中必须设置
            //连接时间是 从发送请求开始 到连接到主机地址的时间
            conn.setConnectTimeout(15000);
            //读取时间  连接成功后，进行内容获取的时间
            conn.setReadTimeout(60000);
            //设置请求的参数-让返回的数为json格式
            conn.setRequestProperty("Accept","application/json");
            //发送请求
            conn.connect();
            //识别返回的状态码
            //一般我们再判断是把已知的数放在前面
            if (200==conn.getResponseCode()){//200表示成功-我们开始获取数据
                is=conn.getInputStream();//获取连接中的输入流
                //InputStream 是字节流-多用来处理二进制数据
               // InputStream是字节流，多用于读取二进制数据
             // InputStreamReader是字符流，多用于读取文本文件。有不同的编码方式，如utf8等。可以在构造的时候指定编码方式。
                br=new BufferedReader(new InputStreamReader(is,"UTF-8"));
                String line;
                while((line=br.readLine())!=null){//这一步相当于每读取一行就把值赋予给变量line，当读取到没有数据的一行时会把null赋予给line此时line为null不满足条件了，循环结束，数据拼接完成
                    result.append(line);
                }
            }else {
                //此时code码不为200，说明没有正常返回
                System.out.println("返回了错误码"+conn.getResponseCode());
            }
        }catch (Exception e){
            e.getMessage();
        }
        finally {
            //在finally中管理流
            try {
                if (br != null) {
                    br.close();
                }
                if (is != null) {
                    is.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            //disconnection表示断开连接--conn也需要关闭
            conn.disconnect();
        }
        return result.toString();
    }

}
