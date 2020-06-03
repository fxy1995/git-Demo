package com.duying.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 付雪缘
 * @Date 2020/5/4 17:11
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Guest {
    private  long id;
    private  String name;
    private String role;
}
