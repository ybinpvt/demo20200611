package com.ybin.demo.controller;

import com.ybin.demo.entity.User;
import com.ybin.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.function.Supplier;

/**
 * @author ybin
 * @version 1.0
 * @date 2020/6/12 16:14
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/getUser/{id}")
    public String getUser(@PathVariable("id") Long id) {
        User user = userRepository.getOne(id);
        return user.toString();
    }

    @GetMapping("addUser")
    public User addUser(@RequestParam("name") String name) {
        User user = new User();
        user.setName(name);
        userRepository.save(user);
        return user;
    }
}
