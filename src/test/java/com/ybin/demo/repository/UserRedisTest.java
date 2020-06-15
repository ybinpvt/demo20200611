package com.ybin.demo.repository;

import com.ybin.demo.entity.jpaEntity.User;
import com.ybin.demo.repository.jpaRepository.UserRepository;
import com.ybin.demo.repository.redisRepository.UserRedis;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * @author ybin
 * @version 1.0
 * @date 2020/6/15 16:18
 */

@SpringBootTest
public class UserRedisTest {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    UserRedis userRedis;
    @Autowired
    UserRepository userRepository;

    @Test
    void addRedis() {
        userRedis.add(String.valueOf(userRepository.getOne(2L).getId()),1,userRepository.findById(2L));
    }

    @Test
    @SuppressWarnings("unchecked")
    void getUserRedis() {
        userRedis.add("ybin",1,userRepository.findById(2L));
        User user = null;
        user = userRedis.get("ybin");
        if (null==user) {
            System.out.println("null");
        } else {
            System.out.println(user.toString());
        }
    }

    @Test
    void redisTest() throws InterruptedException {
        redisTemplate.opsForValue().set("key01","value of key01",1L, TimeUnit.MINUTES);
        for (int i=0;i<30;i++) {
            System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + " key01 ==> " + redisTemplate.opsForValue().get("key01"));
            Thread.sleep(3000L);
        }
    }

}
