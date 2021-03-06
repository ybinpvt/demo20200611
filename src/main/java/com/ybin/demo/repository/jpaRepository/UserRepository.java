package com.ybin.demo.repository.jpaRepository;

import com.ybin.demo.entity.jpaEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ybin
 * @version 1.0
 * @date 2020/6/12 13:00
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
