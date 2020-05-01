package com.duyi.util;

import org.jasypt.util.text.BasicTextEncryptor;

/**
 * @Author 付雪缘
 * @Date 2020/5/1 10:24
 * @Version 1.0
 */

public class JasyptUtil {
  public void test() {
      BasicTextEncryptor encryptor = new BasicTextEncryptor();
      encryptor.setPassword("8455@#%@");//设置需要加得盐
      String name = encryptor.encrypt("张三");
      String password = encryptor.encrypt("123");
      System.out.println(name);
      System.out.println(password);

  }
    public static void main(String[] args) {
      new JasyptUtil().test();
    }
    }


