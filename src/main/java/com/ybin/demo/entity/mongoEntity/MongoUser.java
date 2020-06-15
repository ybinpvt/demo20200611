package com.ybin.demo.entity.mongoEntity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ybin
 * @version 1.0
 * @date 2020/6/15 18:00
 */

@Data
@Document(collection = "user")
public class MongoUser {
    @Id
    private String userId;
    @NotNull
    @Indexed(unique = true)
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registrationDate = LocalDateTime.now();
    private Set<String> roles = new HashSet<>();

    @PersistenceConstructor
    public MongoUser(String userId, String username, String password, String name, String email,
                     LocalDateTime registrationDate, Set<String> roles) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.registrationDate = registrationDate;
        this.roles = roles;
    }
}
