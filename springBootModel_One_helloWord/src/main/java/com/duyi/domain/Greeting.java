package com.duyi.domain;

import lombok.*;

/**
 * @Author 付雪缘
 * @Date 2020/4/30 7:05
 * @Version 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Greeting {
    private long id;
    private String content;
  public  long sid(long id){
      return id;
  }
}