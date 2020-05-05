package com.duing.tx.mapper;

import com.duing.domain.Guest;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author 付雪缘
 * @Date 2020/5/5 18:15
 * @Version 1.0
 */
//现在我们这个接口类啥都不用干只用集成tk.mybatis给好得mapper接口就可以了
    //并且泛型为，我们需要给哪个domain实体服务
public interface GuestMapper extends Mapper<Guest> {
}
