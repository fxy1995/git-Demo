package com.duing.service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.duing.domain.DataBean;
import com.duing.mapper.DataMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 付雪缘
 * @Date 2020/5/18 14:33
 * @Version 1.0
 */
@Service
//泛型为我们操作的哪个mapper 和实体domain
public class DataServiceImp extends ServiceImpl<DataMapper,DataBean> implements DataService {

}
