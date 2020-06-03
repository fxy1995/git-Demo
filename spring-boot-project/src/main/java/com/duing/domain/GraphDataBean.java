package com.duing.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 付雪缘
 * @Date 2020/5/30 18:22
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GraphDataBean {
   private String date;
   private int confirm;
   private int dead;
   private int heal;
}
