package com.ybin.demo.repository;

import com.ybin.demo.entity.jpaEntity.User;
import com.ybin.demo.repository.jpaRepository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;


/**
 * @author ybin
 * @version 1.0
 * @date 2020/6/12 13:21
 */

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    void addUser() {
        User user = new User();
        user.setName("ybin");
        user.setCreateDate(LocalDateTime.now());
        userRepository.save(user);
    }
}
