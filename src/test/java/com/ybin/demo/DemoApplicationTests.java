package com.ybin.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        String input = new Scanner(System.in).nextLine();
        System.out.println("input=====>" + input);
        contextLoads();
    }

}
