package com.duyi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author 付雪缘
 * @Date 2020/5/1 6:50
 * @Version 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    private String meal;
    private String food;
    private String[] sauce;
}
