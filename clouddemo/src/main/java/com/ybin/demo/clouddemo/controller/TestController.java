package com.ybin.demo.clouddemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @author ybin
 * @version 1.0
 * @date 2020/7/29 9:47
 * @description:
 */


@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping(value = "/call")
    @ResponseBody
    public String callAnswer(String input) {
        String url = "http://localhost:8081/test/ask?input=" + input;
        RestTemplate restTemplate = new RestTemplate();
        String answer = restTemplate.getForObject(url,String.class);
        return answer;
    }
}
