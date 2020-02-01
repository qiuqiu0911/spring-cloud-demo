package dev.qiuqiu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class DemoController {

    @GetMapping("/user/{userId}")
    public String getUserCurrentInfo(@PathVariable("userId") String userId) {
        return new Date().toString() + "*****" + userId;
    }
}
