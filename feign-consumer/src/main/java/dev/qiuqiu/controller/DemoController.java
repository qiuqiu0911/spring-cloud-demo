package dev.qiuqiu.controller;

import dev.qiuqiu.service.IUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


    private final IUserService userService;

    public DemoController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{userId}")
    public String test(@PathVariable("userId") String userId) {
        return userService.getUserCurrentInfo(userId);
    }

}
