package dev.qiuqiu.controller;

import dev.qiuqiu.service.UserFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    private final UserFeignClient userFeignClient;

    public DemoController(UserFeignClient userFeignClient) {
        this.userFeignClient = userFeignClient;
    }

    @GetMapping("/test/{userId}")
    public String test(@PathVariable("userId") String userId) {
        return userFeignClient.getUserCurrentInfo(userId);
    }

}
