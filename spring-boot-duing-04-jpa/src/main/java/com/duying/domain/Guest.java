package com.duying.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Author 付雪缘
 * @Date 2020/5/4 15:59
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Guest  implements Serializable {
    @Id
    private  long id;
    @Column
    private String name;
    @Column
    private String role;
}
