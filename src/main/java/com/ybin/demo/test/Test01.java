package com.ybin.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;

/**
 * @author ybin
 * @version 1.0
 * @date 2020/7/28 10:20
 * @description:
 */

public class Test01 {

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        String input = new Scanner(System.in).nextLine();
        if (input.toLowerCase().equals("exit")) {
            System.out.println("goob-bye");
            return;
        }
        answer(input);
        input();
    }

    public static void answer(String input) {
        String url = "http://api.douqq.com/?key=L0ZFTT1Rem13UD04aWowRUIvY2VKaXZmWUJ3QUFBPT0&msg=" + input;
        RestTemplate restTemplate = new RestTemplate();
        String answer = restTemplate.getForObject(url,String.class);
        System.out.println(answer);
        System.out.println("answer:" + answer);
    }

}
