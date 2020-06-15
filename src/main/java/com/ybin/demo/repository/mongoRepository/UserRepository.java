package com.ybin.demo.repository.mongoRepository;

import com.ybin.demo.entity.mongoEntity.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ybin
 * @version 1.0
 * @date 2020/6/15 18:15
 */

@Repository
public interface UserRepository extends MongoRepository<MongoUser,String> {
}
