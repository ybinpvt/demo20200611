package com.ybin.demo.redis;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ybin.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author ybin
 * @version 1.0
 * @date 2020/6/12 16:39
 */

@Repository
public class UserRedis {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**
     * key,过期时间分钟，value
     * @param key
     * @param time
     * @param user
     */
    public void add(String key, Long time, User user) {
        Gson gson = new Gson();
        redisTemplate.opsForValue().set(key,gson.toJson(user),time, TimeUnit.MINUTES);
    }

    /**
     * @param key
     * @param time
     * @param users
     */
    public void add(String key, int time, Optional<User> users) {
        Gson gson = new Gson();
        redisTemplate.opsForValue().set(key,gson.toJson(users),time,TimeUnit.MINUTES);
    }

    /**
     *
     * @param key
     * @return
     */
    public User get(String key) {
        Gson gson = new Gson();
        User user = null;
        String userJson = redisTemplate.opsForValue().get(key);
        if (!StringUtils.isEmpty(userJson)) {
            user = gson.fromJson(userJson,User.class);
        }
        return user;
    }

    public List<User> getList(String key) {
        Gson gson = new Gson();
        List<User> list = null;
        String listJson = redisTemplate.opsForValue().get(key);
        if (!StringUtils.isEmpty(listJson)) {
            list = gson.fromJson(listJson,new TypeToken<List<User>>() {}.getType());
        }
        return list;
    }

    public void delete(String key) {
        redisTemplate.opsForValue().getOperations().delete(key);
    }
}
