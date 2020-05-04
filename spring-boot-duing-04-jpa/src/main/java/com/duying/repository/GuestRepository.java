package com.duying.repository;

import com.duying.domain.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author 付雪缘
 * @Date 2020/5/4 16:01
 * @Version 1.0
 */
public interface GuestRepository extends JpaRepository<Guest,Long> {
}
